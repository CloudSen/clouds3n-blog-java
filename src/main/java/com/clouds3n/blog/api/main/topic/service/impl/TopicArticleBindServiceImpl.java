package com.clouds3n.blog.api.main.topic.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.api.main.blog.dto.ArticleSummaryDto;
import com.clouds3n.blog.api.main.blog.dto.ArticleTagConn;
import com.clouds3n.blog.api.main.blog.entity.Article;
import com.clouds3n.blog.api.main.blog.service.IArticleService;
import com.clouds3n.blog.api.main.blog.service.IArticleTagBindService;
import com.clouds3n.blog.api.main.topic.dto.TopicArticleSummaryDto;
import com.clouds3n.blog.api.main.topic.entity.Topic;
import com.clouds3n.blog.api.main.topic.entity.TopicArticleBind;
import com.clouds3n.blog.api.main.topic.mapper.TopicArticleBindMapper;
import com.clouds3n.blog.api.main.topic.service.ITopicArticleBindService;
import com.clouds3n.blog.api.main.topic.service.ITopicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 专题-文章多对多映射 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-05-02
 */
@Service
public class TopicArticleBindServiceImpl
    extends ServiceImpl<TopicArticleBindMapper, TopicArticleBind> implements ITopicArticleBindService {

    private final ITopicService topicService;
    private final IArticleService articleService;
    private final IArticleTagBindService articleTagBindService;

    public TopicArticleBindServiceImpl(ITopicService topicService, IArticleService articleService,
                                       IArticleTagBindService articleTagBindService) {
        this.topicService = topicService;
        this.articleService = articleService;
        this.articleTagBindService = articleTagBindService;
    }

    @Override
    public TopicArticleSummaryDto getArticlesByTopicId(String topicId) {
        Topic topic = topicService.getOne(Wrappers.lambdaQuery(Topic.class).eq(Topic::getUuid, topicId).select(Topic::getTopicName));
        List<TopicArticleBind> topicArticleBindList = this.list(
            Wrappers.lambdaQuery(TopicArticleBind.class)
                .eq(TopicArticleBind::getDeleted, false)
                .eq(TopicArticleBind::getTopicUuid, topicId)
        );
        List<Article> articleList = articleService.list(
            Wrappers.lambdaQuery(Article.class)
                .eq(Article::getDeleted, false)
                .in(Article::getUuid, topicArticleBindList.stream().map(TopicArticleBind::getArticleUuid).collect(Collectors.toList()))
        );
        List<ArticleTagConn> articleTagConnList = articleTagBindService.buildArticleTagConnList(articleList);
        List<ArticleSummaryDto> articleSummaryDtoList = articleTagConnList.stream().map(ArticleSummaryDto::new).collect(Collectors.toList());
        return new TopicArticleSummaryDto()
            .setArticleSummaryDtoList(articleSummaryDtoList)
            .setTopicName(topic.getTopicName());
    }
}
