package com.clouds3n.blog.dashboard.monitor.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author CloudS3n
 * @date 2020-05-31 13:19
 */
@Data
@Accessors(chain = true)
public class MonitorDataDto implements Serializable {

    private static final long serialVersionUID = 1837683978472379260L;
    private Long totalArticleCount;
    private Long monthArticleCount;
    private Long yearArticleCount;
    private Long totalTagCount;
    private Long totalTopicCount;
    private Long totalCommentCount;
}
