package com.clouds3n.blog.api.main.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.clouds3n.blog.api.main.blog.dto.ArticleSummaryDto;
import com.clouds3n.blog.api.main.blog.entity.ArticleTagBind;
import com.clouds3n.blog.common.PaginationDto;

/**
 * <p>
 * 文章-标签多对多关系表 服务类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
public interface IArticleTagBindService extends IService<ArticleTagBind> {

    /**
     * <p>查询文章摘要列表</p>
     * <p>自定义条件分页查询</p>
     *
     * @param condition 分页参数和查询条件
     * @return 分页后的文章列表
     * @throws IllegalAccessException 非法访问
     */
    Page<ArticleSummaryDto> queryPagedArticleSummary(PaginationDto<ArticleSummaryDto> condition) throws IllegalAccessException;
}