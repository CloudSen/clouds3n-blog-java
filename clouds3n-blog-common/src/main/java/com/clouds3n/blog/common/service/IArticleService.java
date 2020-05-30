package com.clouds3n.blog.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clouds3n.blog.common.entity.Article;
import com.clouds3n.blog.common.service.dto.ArticleFullInfoDto;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
public interface IArticleService extends IService<Article> {

    /**
     * 保存文章以及文章与标签，文章与主题的关系
     *
     * @param articleFullInfoDto 文章信息
     */
    void saveOrUpdateFullArticle(ArticleFullInfoDto articleFullInfoDto);

    /**
     * 删除某篇文章（物理删除）
     *
     * @param articleId 文章ID
     */
    void deleteOneArticle(String articleId);
}
