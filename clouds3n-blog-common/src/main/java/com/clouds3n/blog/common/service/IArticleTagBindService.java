package com.clouds3n.blog.common.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.clouds3n.blog.common.entity.Article;
import com.clouds3n.blog.common.entity.ArticleTagBind;
import com.clouds3n.blog.common.service.dto.ArticleFullInfoDto;
import com.clouds3n.blog.common.service.dto.ArticleSummaryDto;
import com.clouds3n.blog.common.service.dto.ArticleSummaryPageByTagDto;
import com.clouds3n.blog.common.service.dto.ArticleTagConn;
import com.clouds3n.config.mybatisplus.query.PaginationDto;

import java.util.List;

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

    /**
     * 通过文章ID，获取文章全部信息
     *
     * @param articleId 文章ID
     * @return 文章全部信息
     */
    ArticleFullInfoDto queryArticleFullInfoById(String articleId);

    /**
     * 通过标签id获取文章摘要列表
     *
     * @param condition 分页参数, 标签ID
     * @return 分页后的文章列表
     */
    Page<ArticleSummaryDto> queryPagedArticleSummaryByTag(ArticleSummaryPageByTagDto condition);

    /**
     * 根据文章列表，构建文章和标签的关系
     *
     * @param articleList 文章列表
     * @return 文章和标签的关系列表
     */
    List<ArticleTagConn> buildArticleTagConnList(List<Article> articleList);

    /**
     * 构建某一篇文章与标签的关系
     *
     * @param article 某篇文章
     * @return 文章与标签的关系
     */
    ArticleTagConn buildArticleTagConn(Article article);
}
