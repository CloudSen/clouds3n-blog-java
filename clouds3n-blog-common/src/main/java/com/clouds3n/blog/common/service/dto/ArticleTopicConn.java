package com.clouds3n.blog.common.service.dto;

import com.clouds3n.blog.common.entity.Topic;
import com.clouds3n.blog.common.entity.TopicArticleBind;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author CloudS3n
 * @date 2020-05-29 21:46
 */
@Data
@Accessors(chain = true)
public class ArticleTopicConn {
    private ArticleSummaryDto articleSummaryDto;
    private List<TopicDto> topicDtoList;

    public void saveTagIdList(Map<String, List<TopicArticleBind>> topicArticleBindMap) {
        List<TopicDto> topicDtoList = new ArrayList<>();
        topicArticleBindMap.forEach((articleId, topicArticleBinds) -> {
            if (StringUtils.equals(articleId, articleSummaryDto.getUuid())) {
                topicArticleBinds.forEach(topicArticleBind -> topicDtoList.add(new TopicDto().setUuid(topicArticleBind.getTopicUuid())));
            }
        });
        this.topicDtoList = topicDtoList;
    }

    public void saveTagIdList(List<TopicArticleBind> topicArticleBindList) {
        List<TopicDto> topicDtoList = new ArrayList<>();
        topicArticleBindList.forEach(topicArticleBind -> topicDtoList.add(new TopicDto().setUuid(topicArticleBind.getTopicUuid())));
        this.topicDtoList = topicDtoList;
    }

    public void saveTagDetailList(List<Topic> topicList) {
        this.topicDtoList = topicList.stream()
            .filter(topic -> this.topicDtoList.stream().map(TopicDto::getUuid).collect(Collectors.toList()).contains(topic.getUuid()))
            .map(TopicDto::new)
            .collect(Collectors.toList());
    }
}
