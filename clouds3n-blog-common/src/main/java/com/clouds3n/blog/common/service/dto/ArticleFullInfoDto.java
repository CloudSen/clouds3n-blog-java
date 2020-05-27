package com.clouds3n.blog.common.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author CloudS3n
 * @date 2020-05-27 0:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
public class ArticleFullInfoDto extends ArticleSummaryDto {
    private static final long serialVersionUID = -75158197524965030L;
    private String content;
    private String imgUrl;

    public ArticleFullInfoDto(ArticleTagConn article) {
        super(article);
    }
}
