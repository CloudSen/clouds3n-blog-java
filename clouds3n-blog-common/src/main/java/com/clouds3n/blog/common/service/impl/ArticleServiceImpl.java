package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.entity.Article;
import com.clouds3n.blog.common.entity.ArticleTagBind;
import com.clouds3n.blog.common.entity.TopicArticleBind;
import com.clouds3n.blog.common.mapper.ArticleMapper;
import com.clouds3n.blog.common.mapper.ArticleTagBindMapper;
import com.clouds3n.blog.common.mapper.TopicArticleBindMapper;
import com.clouds3n.blog.common.service.IArticleService;
import com.clouds3n.blog.common.service.dto.ArticleFullInfoDto;
import com.clouds3n.blog.common.service.dto.ArticleTagDto;
import com.clouds3n.blog.common.service.dto.TopicDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    private final ArticleTagBindMapper articleTagBindMapper;
    private final TopicArticleBindMapper topicArticleBindMapper;

    public ArticleServiceImpl(ArticleTagBindMapper articleTagBindMapper,
                              TopicArticleBindMapper topicArticleBindMapper) {
        this.articleTagBindMapper = articleTagBindMapper;
        this.topicArticleBindMapper = topicArticleBindMapper;
    }

    @Override
    public void saveOrUpdateFullArticle(ArticleFullInfoDto articleFullInfoDto) {
        Article article = articleFullInfoDto.toArticleEntity();
        List<ArticleTagDto> tags = articleFullInfoDto.getTags();
        List<TopicDto> topics = articleFullInfoDto.getTopics();
        if (CollectionUtils.isEmpty(tags)) {
            throw new IllegalArgumentException("文章标签不能为空");
        }
        this.saveOrUpdate(article);

        articleTagBindMapper.delete(
            Wrappers.lambdaQuery(ArticleTagBind.class)
                .eq(ArticleTagBind::getArticleId, article.getUuid())
        );
        for (ArticleTagDto tag : tags) {
            ArticleTagBind newBind = new ArticleTagBind()
                .setTagId(tag.getUuid())
                .setArticleId(article.getUuid());
            articleTagBindMapper.insert(newBind);
        }

        topicArticleBindMapper.delete(
            Wrappers.lambdaQuery(TopicArticleBind.class)
                .eq(TopicArticleBind::getArticleUuid, article.getUuid())
        );
        for (TopicDto topic : topics) {
            TopicArticleBind newBind = new TopicArticleBind()
                .setArticleUuid(article.getUuid())
                .setTopicUuid(topic.getUuid());
            topicArticleBindMapper.insert(newBind);
        }
    }

    @Override
    public void deleteOneArticle(String articleId) {
        this.removeById(articleId);
        articleTagBindMapper.delete(
            Wrappers.lambdaQuery(ArticleTagBind.class)
                .eq(ArticleTagBind::getArticleId, articleId)
        );
        topicArticleBindMapper.delete(
            Wrappers.lambdaQuery(TopicArticleBind.class)
                .eq(TopicArticleBind::getArticleUuid, articleId)
        );
    }
}
