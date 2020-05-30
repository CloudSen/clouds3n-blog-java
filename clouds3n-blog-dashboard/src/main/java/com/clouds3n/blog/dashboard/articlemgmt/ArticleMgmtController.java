package com.clouds3n.blog.dashboard.articlemgmt;

import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.common.service.IArticleService;
import com.clouds3n.blog.common.service.IArticleTagBindService;
import com.clouds3n.blog.common.service.dto.ArticleFullInfoDto;
import com.clouds3n.blog.common.service.dto.ArticleSummaryDto;
import com.clouds3n.blog.common.utils.ColumnUtil;
import com.clouds3n.config.mybatisplus.query.PaginationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author CloudS3n
 * @date 2020-05-23 12:10
 */
@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleMgmtController {

    private final IArticleTagBindService articleTagBindService;
    private final IArticleService articleService;

    public ArticleMgmtController(IArticleTagBindService articleTagBindService, IArticleService articleService) {
        this.articleTagBindService = articleTagBindService;
        this.articleService = articleService;
    }

    @PostMapping("/queryPage")
    public Res queryPage(@RequestBody PaginationDto<ArticleSummaryDto> condition) throws IllegalAccessException {
        condition.getPage().getOrders().forEach(orderItem -> orderItem.setColumn(ColumnUtil.toDbColumn(orderItem.getColumn())));
        return Res.ok(articleTagBindService.queryPagedArticleSummary(condition));
    }

    @GetMapping("/{articleId}")
    public Res getArticleFullInfo(@PathVariable("articleId") String articleId) {
        return Res.ok(articleTagBindService.queryArticleFullInfoById(articleId));
    }

    @PostMapping("")
    public Res saveOrUpdate(@RequestBody ArticleFullInfoDto articleFullInfoDto) {
        articleService.saveOrUpdateFullArticle(articleFullInfoDto);
        return Res.ok();
    }

    @DeleteMapping("/{articleId}")
    public Res deleteOneArticle(@PathVariable("articleId") String articleId) {
        articleService.deleteOneArticle(articleId);
        return Res.ok();
    }
}
