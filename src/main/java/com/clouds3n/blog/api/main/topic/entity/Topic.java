package com.clouds3n.blog.api.main.topic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.clouds3n.blog.api.main.topic.TopicDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 专题
 * </p>
 *
 * @author CloudS3n
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "uuid", type = IdType.ASSIGN_UUID)
    private String uuid;

    /**
     * 父主题主键，若自己时父类，则为-1
     */
    private String parentUuid;

    /**
     * 专题名
     */
    private String topicName;

    /**
     * 专题名文字css
     */
    private String topicNameClass;

    /**
     * 显示顺序
     */
    private Integer showOrder;

    /**
     * 主题图片url
     */
    private String topicImg;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除【0：未删除，1：已删除】
     */
    private Boolean deleted;

    public TopicDto toTopicDto() {
        return new TopicDto(this);
    }
}
