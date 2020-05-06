package com.clouds3n.blog.common.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clouds3n.blog.common.entity.Article;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 专题文章分页
 *
 * @author CloudS3n
 * @date 2020-05-02 21:43
 */
@Data
@Accessors(chain = true)
@Deprecated
public class TopicDetailPage implements Serializable {
    private static final long serialVersionUID = -7205283556296138079L;
    private Page<Article> page;
    private String topicId;
}
