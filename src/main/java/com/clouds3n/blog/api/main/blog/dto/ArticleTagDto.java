package com.clouds3n.blog.api.main.blog.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 文章标签
 *
 * @author CloudS3n
 * @date 2020-04-19 15:22
 */
@Data
@Accessors(chain = true)
public class ArticleTagDto implements Serializable {
    private static final long serialVersionUID = 3530646497663899850L;
    private String uuid;
    private String name;
    private String color;
}
