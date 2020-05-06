package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.SysCode;
import com.clouds3n.blog.common.entity.Topic;
import com.clouds3n.blog.common.mapper.TopicMapper;
import com.clouds3n.blog.common.service.ITopicService;
import com.clouds3n.blog.common.service.dto.TopicDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 专题 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-05-02
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements ITopicService {

    @Override
    public List<TopicDto> buildTopicList() {
        final List<Topic> topicOriginList = this.list(Wrappers.lambdaQuery(Topic.class).eq(Topic::getDeleted, SysCode.NUM0));
        if (CollectionUtils.isEmpty(topicOriginList)) {
            return null;
        }
        List<TopicDto> topicList = topicOriginList.stream()
            .filter(topic -> StringUtils.equals(topic.getParentUuid(), SysCode.NEGATIVE_STR_1))
            .map(Topic::toTopicDto)
            .collect(Collectors.toList());
        topicList.forEach(topicDto -> topicOriginList.forEach(topic -> {
            if (StringUtils.equals(topicDto.getUuid(), topic.getParentUuid())) {
                topicDto.getChildList().add(topic.toTopicDto());
            }
        }));
        return topicList;
    }
}
