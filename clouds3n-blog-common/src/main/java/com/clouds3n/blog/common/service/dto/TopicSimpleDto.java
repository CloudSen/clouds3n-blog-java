package com.clouds3n.blog.common.service.dto;

import com.clouds3n.blog.common.entity.Topic;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author CloudS3n
 * @date 2020-05-29 21:38
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class TopicSimpleDto implements Serializable {

    private static final long serialVersionUID = -7104759830428913025L;
    private String uuid;
    private String topicName;

    public TopicSimpleDto(Topic topic) {
        this.uuid = topic.getUuid();
        this.topicName = topic.getTopicName();
    }
}
