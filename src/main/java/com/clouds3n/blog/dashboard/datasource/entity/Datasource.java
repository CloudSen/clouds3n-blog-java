package com.clouds3n.blog.dashboard.datasource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 动态数据源
 * </p>
 *
 * @author CloudS3n
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Datasource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * uuid-32
     */
    @TableId(value = "uuid", type = IdType.ASSIGN_UUID)
    private String uuid;

    /**
     * 数据源名
     */
    private String pollName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 驱动完整包名
     */
    private String driverClassName;

    /**
     * 数据库地址
     */
    private String url;

    /**
     * Druid参数ID
     */
    private String druidPropertiesId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 0未删除，1已删除
     */
    private Boolean deleted;

    /**
     * 备注
     */
    private String comment;


}
