package com.clouds3n.blog.api.main.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.api.main.blog.entity.Article;
import com.clouds3n.blog.api.main.blog.mapper.ArticleMapper;
import com.clouds3n.blog.api.main.blog.service.IArticleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
