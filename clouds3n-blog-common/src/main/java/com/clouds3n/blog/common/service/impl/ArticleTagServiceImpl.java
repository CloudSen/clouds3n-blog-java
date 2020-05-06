package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.entity.ArticleTag;
import com.clouds3n.blog.common.mapper.ArticleTagMapper;
import com.clouds3n.blog.common.service.IArticleTagService;
import org.springframework.stereotype.Service;

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

}
