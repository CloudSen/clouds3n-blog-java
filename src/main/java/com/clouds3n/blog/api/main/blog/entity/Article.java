package com.clouds3n.blog.api.main.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID-32
     */
    @TableId(value = "uuid", type = IdType.ASSIGN_UUID)
    private String uuid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 文章摘要卡片图片url
     */
    private String imgUrlMd;

    /**
     * 文章详情图片url
     */
    private String imgUrl;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章摘要卡片样式
     */
    private String color;

    /**
     * 文章是否过时，0未过时，1已过时
     */
    private Boolean deprecated;

    /**
     * 阅读数，超过999就保存999
     */
    private Integer readCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否已删除，0未删除，1已删除
     */
    private Boolean deleted;


}
