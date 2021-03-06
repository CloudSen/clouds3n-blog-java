package com.clouds3n.blog.common.service.dto;

import com.clouds3n.blog.common.entity.Topic;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 专题列表
 *
 * @author CloudS3n
 * @date 2020-05-02 16:18
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class TopicDto implements Serializable {

    private static final long serialVersionUID = 1753834292876036193L;
    private String uuid;
    private String parentUuid;
    private String topicName;
    private String topicNameClass;
    private Integer showOrder;
    private String topicImg;
    private List<TopicDto> childList;

    public TopicDto(Topic topic) {
        this.uuid = topic.getUuid();
        this.parentUuid = topic.getParentUuid();
        this.topicName = topic.getTopicName();
        this.topicNameClass = topic.getTopicNameClass();
        this.showOrder = topic.getShowOrder();
        this.topicImg = topic.getTopicImg();
        this.childList = new ArrayList<>();
    }
}
