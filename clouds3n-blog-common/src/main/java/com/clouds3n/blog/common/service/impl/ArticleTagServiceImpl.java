package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.entity.ArticleTag;
import com.clouds3n.blog.common.mapper.ArticleTagMapper;
import com.clouds3n.blog.common.service.IArticleTagService;
import com.clouds3n.blog.common.service.dto.ArticleTagSimpleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 文章标签表 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-02-18
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements IArticleTagService {

    @Override
    public List<ArticleTagSimpleDto> getAllTagList() {
        List<ArticleTag> articleTagList = this.list();
        if (CollectionUtils.isEmpty(articleTagList)) {
            return null;
        }
        return articleTagList.stream().map(ArticleTagSimpleDto::new).collect(Collectors.toList());
    }
}
