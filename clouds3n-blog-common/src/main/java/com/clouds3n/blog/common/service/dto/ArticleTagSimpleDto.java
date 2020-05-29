package com.clouds3n.blog.common.service.dto;

import com.clouds3n.blog.common.entity.ArticleTag;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author CloudS3n
 * @date 2020-05-29 21:42
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ArticleTagSimpleDto implements Serializable {

    private static final long serialVersionUID = -4102058093247217545L;
    private String uuid;
    private String name;

    public ArticleTagSimpleDto(ArticleTag articleTag) {
        this.uuid = articleTag.getUuid();
        this.name = articleTag.getName();
    }
}
