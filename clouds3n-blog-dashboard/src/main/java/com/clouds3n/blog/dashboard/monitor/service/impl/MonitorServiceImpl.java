package com.clouds3n.blog.dashboard.monitor.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.clouds3n.blog.common.SysCode;
import com.clouds3n.blog.common.entity.Article;
import com.clouds3n.blog.common.entity.Topic;
import com.clouds3n.blog.common.service.IArticleService;
import com.clouds3n.blog.common.service.IArticleTagService;
import com.clouds3n.blog.common.service.ITopicService;
import com.clouds3n.blog.dashboard.monitor.dto.MonitorCardDto;
import com.clouds3n.blog.dashboard.monitor.dto.MonitorDataDto;
import com.clouds3n.blog.dashboard.monitor.service.MonitorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.List;

/**
 * @author CloudS3n
 * @date 2020-05-31 13:22
 */
@Service
public class MonitorServiceImpl implements MonitorService {

    private final IArticleService articleService;
    private final IArticleTagService tagService;
    private final ITopicService topicService;

    public MonitorServiceImpl(IArticleService articleService, IArticleTagService tagService, ITopicService topicService) {
        this.articleService = articleService;
        this.tagService = tagService;
        this.topicService = topicService;
    }

    @Override
    public MonitorDataDto getMonitorData() {
        long totalArticleCount = articleService.count();
        long totalTagCount = tagService.count();
        long totalCommentCount = 0;
        long totalTopicCount = topicService.count(
            Wrappers.lambdaQuery(Topic.class)
                .ne(Topic::getParentUuid, SysCode.NEGATIVE_STR_1)
        );
        long monthArticleCount = articleService.count(
            Wrappers.lambdaQuery(Article.class)
                .gt(Article::getUpdateTime, LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()))
                .lt(Article::getUpdateTime, LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()))
        );
        long yearArticleCount = articleService.count(
            Wrappers.lambdaQuery(Article.class)
                .gt(Article::getUpdateTime, LocalDateTime.now().with(TemporalAdjusters.firstDayOfYear()))
                .lt(Article::getUpdateTime, LocalDateTime.now().with(TemporalAdjusters.lastDayOfYear()))
        );
        return new MonitorDataDto()
            .setTotalArticleCount(totalArticleCount)
            .setTotalCommentCount(totalCommentCount)
            .setTotalTagCount(totalTagCount)
            .setTotalTopicCount(totalTopicCount)
            .setMonthArticleCount(monthArticleCount)
            .setYearArticleCount(yearArticleCount);
    }

    @Override
    public List<MonitorCardDto> getMonitorCardData() {
        MonitorDataDto monitorData = this.getMonitorData();
        return Arrays.asList(
            new MonitorCardDto().setType("article").setCount(monitorData.getTotalArticleCount()),
            new MonitorCardDto().setType("monthArticle").setCount(monitorData.getMonthArticleCount()),
            new MonitorCardDto().setType("yearArticle").setCount(monitorData.getYearArticleCount()),
            new MonitorCardDto().setType("tag").setCount(monitorData.getTotalTagCount()),
            new MonitorCardDto().setType("topic").setCount(monitorData.getTotalTopicCount()),
            new MonitorCardDto().setType("comment").setCount(monitorData.getTotalCommentCount())
        );
    }
}
