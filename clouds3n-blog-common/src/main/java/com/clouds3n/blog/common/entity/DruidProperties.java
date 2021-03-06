package com.clouds3n.blog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * Druid参数
 * </p>
 *
 * @author CloudS3n
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DruidProperties implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uuid", type = IdType.ASSIGN_UUID)
    private String uuid;

    /**
     * 初始化大小
     */
    @NotNull
    @Range(min = 50, max = 1000)
    private Integer initialSize;

    /**
     * 最大连接数
     */
    @NotNull
    @Range(min = 100, max = 3000)
    private Integer maxActive;

    /**
     * 最小空闲连接数
     */
    @NotNull
    @Range(min = 40, max = 60)
    private Integer minIdle;

    /**
     * 最大等待时常
     */
    private Integer maxWait;

    /**
     * 空闲时是否检测可用性，1检测，0不检测
     */
    private Boolean testWhileIdle;

    /**
     * 测试语句
     */
    private String validationQuery;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 0未删除，1删除
     */
    private Boolean deleted;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String comment;


}
