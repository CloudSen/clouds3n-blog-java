package com.clouds3n.blog.dashboard.articlemgmt;

import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.common.service.IArticleTagBindService;
import com.clouds3n.blog.common.service.dto.ArticleSummaryDto;
import com.clouds3n.blog.common.utils.ColumnUtil;
import com.clouds3n.config.mybatisplus.query.PaginationDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CloudS3n
 * @date 2020-05-23 12:10
 */
@RestController
@RequestMapping("/article")
public class ArticleMgmtController {

    private final IArticleTagBindService articleTagBindService;

    public ArticleMgmtController(IArticleTagBindService articleTagBindService) {
        this.articleTagBindService = articleTagBindService;
    }

    @PostMapping("/queryPage")
    public Res queryPage(@RequestBody PaginationDto<ArticleSummaryDto> condition) throws IllegalAccessException {
        condition.getPage().getOrders().forEach(orderItem -> orderItem.setColumn(ColumnUtil.toDbColumn(orderItem.getColumn())));
        return Res.ok(articleTagBindService.queryPagedArticleSummary(condition));
    }
}
