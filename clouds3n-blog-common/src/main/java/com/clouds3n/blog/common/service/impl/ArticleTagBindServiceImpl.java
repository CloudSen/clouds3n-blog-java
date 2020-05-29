package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.entity.*;
import com.clouds3n.blog.common.mapper.*;
import com.clouds3n.blog.common.service.IArticleTagBindService;
import com.clouds3n.blog.common.service.dto.*;
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
    private final TopicMapper topicMapper;
    private final TopicArticleBindMapper topicArticleBindMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public ArticleTagBindServiceImpl(ArticleTagBindMapper articleTagBindMapper, ArticleMapper articleMapper, ArticleTagMapper articleTagMapper, TopicMapper topicMapper, TopicArticleBindMapper topicArticleBindMapper) {
        this.articleTagBindMapper = articleTagBindMapper;
        this.articleMapper = articleMapper;
        this.articleTagMapper = articleTagMapper;
        this.topicMapper = topicMapper;
        this.topicArticleBindMapper = topicArticleBindMapper;
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
        List<ArticleTagConn> articleTagConnList = buildArticleTagConnList(articleList);
        List<ArticleTopicConn> articleTopicConnList = buildArticleTopicConnList(articleList);
        resultPage.setRecords(ArticleSummaryDto.buildArticleSummaryDtoList(articleTagConnList, articleTopicConnList))
            .setSize(articlePage.getSize()).setPages(articlePage.getPages()).setTotal(articlePage.getTotal());
        return resultPage;
    }

    @Override
    public ArticleFullInfoDto queryArticleFullInfoById(String articleId) {
        Article article = articleMapper.selectById(articleId);
        ArticleTagConn articleTagConn = buildArticleTagConn(article);
        ArticleTopicConn articleTopicConn = buildArticleTopicConn(article);
        return ArticleFullInfoDto.buildArticleFullInfoDto(articleTagConn, articleTopicConn)
            .setContent(article.getContent())
            .setImgUrl(article.getImgUrl());
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

    @Override
    public List<ArticleTopicConn> buildArticleTopicConnList(List<Article> articleList) {
        List<ArticleTopicConn> articleTopicConnList = new ArrayList<>();
        articleList.forEach(article -> articleTopicConnList.add(new ArticleTopicConn().setArticleSummaryDto(article.toSummaryDto())));
        // 查询当前页文章相关的专题id，key是articleId
        List<TopicArticleBind> topicArticleBindList = topicArticleBindMapper.selectList(
            Wrappers.lambdaQuery(TopicArticleBind.class)
                .in(TopicArticleBind::getTopicUuid, articleList.stream().map(Article::getUuid).collect(Collectors.toList()))
        );
        articleTopicConnList.forEach(articleTopicConn -> articleTopicConn.saveTagIdList(topicArticleBindList.stream().collect(Collectors.groupingBy(TopicArticleBind::getArticleUuid))));
        // 查询当前页文章的全部专题
        final List<Topic> topicList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(topicArticleBindList)) {
            topicList.addAll(
                topicMapper.selectList(
                    Wrappers.lambdaQuery(Topic.class)
                        .in(Topic::getUuid, topicArticleBindList.stream().map(TopicArticleBind::getTopicUuid).collect(Collectors.toList()))
                )
            );
        }
        // 文章和标签完整信息
        articleTopicConnList.forEach(articleTopicConn -> articleTopicConn.saveTagDetailList(topicList));
        return articleTopicConnList;
    }

    @Override
    public ArticleTagConn buildArticleTagConn(Article article) {
        ArticleTagConn articleTagConn = new ArticleTagConn()
            .setArticleSummaryDto(article.toSummaryDto());
        final List<ArticleTag> tagList = new ArrayList<>();
        List<ArticleTagBind> articleTagBindList = this.list(
            Wrappers.lambdaQuery(ArticleTagBind.class)
                .eq(ArticleTagBind::getArticleId, articleTagConn.getArticleSummaryDto().getUuid())
        );
        articleTagConn.saveTagIdList(articleTagBindList);
        if (CollectionUtils.isNotEmpty(articleTagBindList)) {
            tagList.addAll(
                articleTagMapper.selectList(
                    Wrappers.lambdaQuery(ArticleTag.class)
                        .in(ArticleTag::getUuid, articleTagBindList.stream().map(ArticleTagBind::getTagId).collect(Collectors.toList()))
                )
            );
        }
        articleTagConn.saveTagDetailList(tagList);
        return articleTagConn;
    }

    @Override
    public ArticleTopicConn buildArticleTopicConn(Article article) {
        ArticleTopicConn articleTopicConn = new ArticleTopicConn()
            .setArticleSummaryDto(article.toSummaryDto());
        final List<Topic> topicList = new ArrayList<>();
        List<TopicArticleBind> topicArticleBindList = topicArticleBindMapper.selectList(
            Wrappers.lambdaQuery(TopicArticleBind.class)
                .eq(TopicArticleBind::getArticleUuid, articleTopicConn.getArticleSummaryDto().getUuid())
        );
        articleTopicConn.saveTagIdList(topicArticleBindList);
        if (CollectionUtils.isNotEmpty(topicArticleBindList)) {
            topicList.addAll(
                topicMapper.selectList(
                    Wrappers.lambdaQuery(Topic.class)
                        .in(Topic::getUuid, topicArticleBindList.stream().map(TopicArticleBind::getTopicUuid).collect(Collectors.toList()))
                )
            );
        }
        articleTopicConn.saveTagDetailList(topicList);
        return articleTopicConn;
    }
}
