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
 * 文章-标签多对多关系表
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArticleTagBind implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关系表主键
     */
    @TableId(value = "uuid", type = IdType.ASSIGN_UUID)
    private String uuid;

    /**
     * 文章表主键
     */
    private String articleId;

    /**
     * 文章标签表主键
     */
    private String tagId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除，0未删除，1已删除
     */
    private Boolean deleted;


}
