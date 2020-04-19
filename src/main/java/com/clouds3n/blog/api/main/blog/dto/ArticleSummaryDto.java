package com.clouds3n.blog.api.main.blog.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 文章摘要
 *
 * @author CloudS3n
 * @date 2020-04-19 15:20
 */
@Data
@Accessors(chain = true)
public class ArticleSummaryDto implements Serializable {
    private static final long serialVersionUID = 2038262008918183958L;
    private String uuid;
    private String title;
    private String summary;
    private String color;
    private String imgUrlMd;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private List<ArticleTagDto> tags;
}
