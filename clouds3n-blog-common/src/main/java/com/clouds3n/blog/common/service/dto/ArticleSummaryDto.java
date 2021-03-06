package com.clouds3n.blog.common.service.dto;

import com.clouds3n.blog.common.entity.Article;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章摘要
 *
 * @author CloudS3n
 * @date 2020-04-19 15:20
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ArticleSummaryDto implements Serializable {
    private static final long serialVersionUID = 2038262008918183958L;
    private String uuid;
    private String title;
    private String summary;
    private String color;
    private String summaryTextColor;
    private String imgUrlMd;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private List<ArticleTagDto> tags;
    private List<TopicDto> topics;

    public ArticleSummaryDto(Article article) {
        this.uuid = article.getUuid();
        this.title = article.getTitle();
        this.summary = article.getSummary();
        this.color = article.getColor();
        this.summaryTextColor = article.getTextColor();
        this.imgUrlMd = article.getImgUrlMd();
        this.createTime = article.getCreateTime();
        this.updateTime = article.getUpdateTime();
    }

    public ArticleSummaryDto(ArticleTagConn article) {
        ArticleSummaryDto summarySlot = article.getArticleSummaryDto();
        this.uuid = summarySlot.getUuid();
        this.title = summarySlot.getTitle();
        this.summary = summarySlot.getSummary();
        this.color = summarySlot.getColor();
        this.summaryTextColor = summarySlot.getSummaryTextColor();
        this.imgUrlMd = summarySlot.getImgUrlMd();
        this.createTime = summarySlot.getCreateTime();
        this.updateTime = summarySlot.getUpdateTime();
        this.tags = article.getArticleTagDtoList();
    }

    public static ArticleSummaryDto buildArticleSummaryDto(ArticleTagConn articleTagConn, ArticleTopicConn articleTopicConn) {
        return articleTagConn.getArticleSummaryDto()
            .setTags(articleTagConn.getArticleTagDtoList())
            .setTopics(articleTopicConn.getTopicDtoList());
    }

    public static List<ArticleSummaryDto> buildArticleSummaryDtoList(List<ArticleTagConn> articleTagConnList, List<ArticleTopicConn> articleTopicConnList) {
        List<ArticleSummaryDto> articleSummaryDtos = new ArrayList<>();
        articleTagConnList.forEach(articleTagConn -> {
            ArticleSummaryDto articleSummaryDto = articleTagConn.getArticleSummaryDto()
                .setTags(articleTagConn.getArticleTagDtoList());
            List<TopicDto> topicDtos = articleTopicConnList.stream()
                .filter(articleTopicConn -> StringUtils.equals(articleTopicConn.getArticleSummaryDto().getUuid(), articleSummaryDto.getUuid()))
                .findFirst()
                .map(ArticleTopicConn::getTopicDtoList)
                .orElse(null);
            articleSummaryDto.setTopics(topicDtos);
            articleSummaryDtos.add(articleSummaryDto);
        });
        return articleSummaryDtos;
    }
}
