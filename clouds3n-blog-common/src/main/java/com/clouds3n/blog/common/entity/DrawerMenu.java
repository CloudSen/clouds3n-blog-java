package com.clouds3n.blog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 抽屉菜单
 * </p>
 *
 * @author CloudS3n
 * @since 2020-02-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DrawerMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID-32
     */
    @TableId(value = "uuid", type = IdType.ASSIGN_UUID)
    private String uuid;

    /**
     * 父菜单UUID-32
     */
    @NotBlank
    private String parentId;

    /**
     * 菜单类型。0：菜单组，1：父类菜单项，2：普通菜单项
     */
    @Range(min = 0, max = 2)
    private Integer type;

    /**
     * 菜单名
     */
    @NotBlank
    private String name;

    /**
     * 前端路由路径
     */
    private String routerPath;

    /**
     * 图标名，如info，timeline
     */
    private String icon;

    /**
     * 排序，越大越往后
     */
    @Range(min = 0, max = Integer.MAX_VALUE)
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
     * 是否已删除，0未删除，1已删除
     */
    private Boolean deleted;


}
