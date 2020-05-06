package com.clouds3n.blog.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clouds3n.blog.common.entity.TopicArticleBind;
import com.clouds3n.blog.common.service.dto.TopicArticleSummaryDto;

/**
 * <p>
 * 专题-文章多对多映射 服务类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-05-02
 */
public interface ITopicArticleBindService extends IService<TopicArticleBind> {

    /**
     * 获取专题的文章摘要列表
     *
     * @param topicId 专题ID
     * @return 文章摘要列表
     */
    TopicArticleSummaryDto getArticlesByTopicId(String topicId);
}
