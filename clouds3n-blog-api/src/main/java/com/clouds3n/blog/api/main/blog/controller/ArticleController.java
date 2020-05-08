package com.clouds3n.blog.api.main.blog.controller;


import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.common.service.IArticleService;
import com.clouds3n.blog.common.service.IArticleTagBindService;
import com.clouds3n.blog.common.service.dto.ArticleSummaryDto;
import com.clouds3n.blog.common.service.dto.ArticleSummaryPageByTagDto;
import com.clouds3n.config.mybatisplus.query.PaginationDto;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@RestController
@RequestMapping("/main/blog/article")
public class ArticleController {

    private final IArticleTagBindService articleTagBindService;
    private final IArticleService articleService;

    public ArticleController(IArticleTagBindService articleTagBindService, IArticleService articleService) {
        this.articleTagBindService = articleTagBindService;
        this.articleService = articleService;
    }

    @PostMapping("/querySummary")
    public Res queryPagedArticleSummary(@RequestBody PaginationDto<ArticleSummaryDto> condition) throws IllegalAccessException {
        return Res.ok(articleTagBindService.queryPagedArticleSummary(condition));
    }

    @PostMapping("/querySummaryByTag")
    public Res queryPagedArticleSummaryByTag(@RequestBody ArticleSummaryPageByTagDto condition) {
        return Res.ok(articleTagBindService.queryPagedArticleSummaryByTag(condition));
    }

    @GetMapping("/{uuid}")
    public Res getArticleDetailById(@PathVariable("uuid") String uuid) {
        return Res.ok(articleService.getById(uuid));
    }
}
