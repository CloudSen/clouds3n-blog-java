package com.clouds3n.blog.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clouds3n.blog.common.entity.ArticleTag;
import com.clouds3n.blog.common.service.dto.ArticleTagSimpleDto;

import java.util.List;

/**
 * <p>
 * 文章标签表 服务类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-02-18
 */
public interface IArticleTagService extends IService<ArticleTag> {

    /**
     * 获取全部标签
     *
     * @return 全部标签列表
     */
    List<ArticleTagSimpleDto> getAllTagList();
}
