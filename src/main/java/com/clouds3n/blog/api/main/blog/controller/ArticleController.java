package com.clouds3n.blog.api.main.blog.controller;


import com.clouds3n.blog.api.main.blog.dto.ArticleSummaryDto;
import com.clouds3n.blog.api.main.blog.service.IArticleService;
import com.clouds3n.blog.api.main.blog.service.IArticleTagBindService;
import com.clouds3n.blog.common.PaginationDto;
import com.clouds3n.blog.common.Res;
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
@RequestMapping("/blog/article")
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

    @GetMapping("/{uuid}")
    public Res getArticleDetailByI(@PathVariable("uuid") String uuid) {
        return Res.ok(articleService.getById(uuid));
    }
}
