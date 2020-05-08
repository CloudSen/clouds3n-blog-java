package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.entity.Article;
import com.clouds3n.blog.common.entity.ArticleTag;
import com.clouds3n.blog.common.entity.ArticleTagBind;
import com.clouds3n.blog.common.mapper.ArticleMapper;
import com.clouds3n.blog.common.mapper.ArticleTagBindMapper;
import com.clouds3n.blog.common.mapper.ArticleTagMapper;
import com.clouds3n.blog.common.service.IArticleTagBindService;
import com.clouds3n.blog.common.service.dto.ArticleSummaryDto;
import com.clouds3n.blog.common.service.dto.ArticleSummaryPageByTagDto;
import com.clouds3n.blog.common.service.dto.ArticleTagConn;
import com.clouds3n.blog.common.utils.QueryWrapperUtil;
import com.clouds3n.config.mybatisplus.query.PaginationDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 文章-标签多对多关系表 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@Service
public class ArticleTagBindServiceImpl extends ServiceImpl<ArticleTagBindMapper, ArticleTagBind> implements IArticleTagBindService {

    private final ArticleTagBindMapper articleTagBindMapper;
    private final ArticleMapper articleMapper;
    private final ArticleTagMapper articleTagMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public ArticleTagBindServiceImpl(ArticleTagBindMapper articleTagBindMapper, ArticleMapper articleMapper, ArticleTagMapper articleTagMapper) {
        this.articleTagBindMapper = articleTagBindMapper;
        this.articleMapper = articleMapper;
        this.articleTagMapper = articleTagMapper;
    }

    @Override
    public Page<ArticleSummaryDto> queryPagedArticleSummary(PaginationDto<ArticleSummaryDto> condition) throws IllegalAccessException {
        // 防止N+1问题，JAVA处理子查询
        // 根据条件查询文章
        Page<ArticleSummaryDto> resultPage = condition.getPage();
        Page<Article> articlePage = new Page<>();
        articlePage.setCurrent(resultPage.getCurrent()).setSize(resultPage.getSize()).setOrders(resultPage.getOrders());
        articleMapper.selectPage(articlePage, QueryWrapperUtil.parseWhereSql(condition.getConditionList(), new Article()));
        List<Article> articleList = articlePage.getRecords();
        if (CollectionUtils.isEmpty(articleList)) {
            return resultPage.setTotal(0);
        }
        resultPage.setRecords(buildArticleTagConnList(articleList).stream().map(ArticleSummaryDto::new).collect(Collectors.toList()))
            .setSize(articlePage.getSize()).setPages(articlePage.getPages()).setTotal(articlePage.getTotal());
        return resultPage;
    }

    @Override
    public Page<ArticleSummaryDto> queryPagedArticleSummaryByTag(ArticleSummaryPageByTagDto condition) {
        LambdaQueryWrapper<ArticleTagBind> bindWrapper = Wrappers.lambdaQuery(new ArticleTagBind()).eq(ArticleTagBind::getTagId, condition.getTagId()).select(ArticleTagBind::getArticleId);
        List<ArticleTagBind> articleTagBinds = this.list(bindWrapper);
        if (CollectionUtils.isEmpty(articleTagBinds)) {
            return null;
        }
        List<String> articleIds = articleTagBinds.stream()
            .map(ArticleTagBind::getArticleId)
            .collect(Collectors.toList());
        return articleTagBindMapper.queryPagedArticleSummary(condition.getPage(), Wrappers.query(new ArticleSummaryDto()).in("a.uuid", articleIds));
    }

    @Override
    public List<ArticleTagConn> buildArticleTagConnList(List<Article> articleList) {
        List<ArticleTagConn> articleTagConnList = new ArrayList<>();
        articleList.forEach(article -> articleTagConnList.add(new ArticleTagConn().setArticleSummaryDto(article.toSummaryDto())));
        // 查询当前页文章相关的标签id，key是articleId
        List<ArticleTagBind> articleTagBindList = this.list(
            Wrappers.lambdaQuery(ArticleTagBind.class)
                .in(ArticleTagBind::getArticleId, articleList.stream().map(Article::getUuid).collect(Collectors.toList()))
        );
        articleTagConnList.forEach(articleTagConn -> articleTagConn.saveTagIdList(articleTagBindList.stream().collect(Collectors.groupingBy(ArticleTagBind::getArticleId))));
        // 查询当前页文章的全部标签
        final List<ArticleTag> tagList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(articleTagBindList)) {
            tagList.addAll(
                articleTagMapper.selectList(
                    Wrappers.lambdaQuery(ArticleTag.class)
                        .in(ArticleTag::getUuid, articleTagBindList.stream().map(ArticleTagBind::getTagId).collect(Collectors.toList()))
                )
            );
        }
        // 文章和标签完整信息
        articleTagConnList.forEach(articleTagConn -> articleTagConn.saveTagDetailList(tagList));
        return articleTagConnList;
    }
}
