package com.clouds3n.blog.api.main.blog.controller;


import com.clouds3n.blog.api.main.blog.dto.ArticleSummaryDto;
import com.clouds3n.blog.api.main.blog.service.IArticleTagBindService;
import com.clouds3n.blog.common.PaginationDto;
import com.clouds3n.blog.common.Res;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public ArticleController(IArticleTagBindService articleTagBindService) {
        this.articleTagBindService = articleTagBindService;
    }

    @PostMapping("/querySummary")
    public Res queryPagedArticleSummary(@RequestBody PaginationDto<ArticleSummaryDto> condition) throws IllegalAccessException {
        return Res.ok(articleTagBindService.queryPagedArticleSummary(condition));
    }
}
