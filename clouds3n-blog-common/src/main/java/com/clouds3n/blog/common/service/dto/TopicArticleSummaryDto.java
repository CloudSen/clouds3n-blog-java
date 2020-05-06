package com.clouds3n.blog.common.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author CloudS3n
 * @date 2020-05-02 22:52
 */
@Data
@Accessors(chain = true)
public class TopicArticleSummaryDto implements Serializable {
    private static final long serialVersionUID = -4943917249921373394L;
    private String topicName;
    private List<ArticleSummaryDto> articleSummaryDtoList;
}
