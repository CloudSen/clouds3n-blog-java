package com.clouds3n.blog.api.header.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * header简单菜单
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class HeaderMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * uuid主键
     */
    @TableId(value = "uuid", type = IdType.ASSIGN_UUID)
    private String uuid;

    /**
     * 菜单名
     */
    private String name;

    /**
     * vue路由
     */
    private String routerPath;

    /**
     * 图标名
     */
    private String icon;

    /**
     * 图标优先级，越大越靠前
     */
    private Integer itemOrder;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否弃用：1弃用 0未弃用
     */
    private Boolean deleted;


}
