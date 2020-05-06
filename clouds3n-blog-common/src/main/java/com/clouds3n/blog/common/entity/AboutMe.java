package com.clouds3n.blog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 关于我
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("about_me")
public class AboutMe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID-32
     */
    @TableId(value = "uuid", type = IdType.ASSIGN_UUID)
    private String uuid;

    /**
     * 介绍，md语法
     */
    private String introduce;

    /**
     * 代码展示，md语法
     */
    private String code;

    /**
     * 联系我，md语法
     */
    private String contact;

    /**
     * 版权信息，md语法
     */
    private String copyright;

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
