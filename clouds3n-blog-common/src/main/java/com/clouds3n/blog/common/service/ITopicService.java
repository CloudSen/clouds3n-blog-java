package com.clouds3n.blog.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clouds3n.blog.common.entity.Topic;
import com.clouds3n.blog.common.service.dto.TopicDto;
import com.clouds3n.blog.common.service.dto.TopicSimpleDto;

import java.util.List;

/**
 * <p>
 * 专题 服务类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-05-02
 */
public interface ITopicService extends IService<Topic> {

    /**
     * 构建专题数据结构
     *
     * @return 具有父子关系的专题列表
     */
    List<TopicDto> buildTopicList();

    /**
     * 获取所有子专题列表
     *
     * @return 所有子专题列表
     */
    List<TopicSimpleDto> getAllSubTopicList();
}
