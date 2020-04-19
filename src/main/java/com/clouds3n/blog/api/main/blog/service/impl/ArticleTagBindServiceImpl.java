package com.clouds3n.blog.api.main.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.api.main.blog.dto.ArticleSummaryDto;
import com.clouds3n.blog.api.main.blog.entity.ArticleTagBind;
import com.clouds3n.blog.api.main.blog.mapper.ArticleTagBindMapper;
import com.clouds3n.blog.api.main.blog.service.IArticleTagBindService;
import com.clouds3n.blog.common.PaginationDto;
import com.clouds3n.blog.util.QueryWrapperUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章-标签多对多关系表 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@Service
public class ArticleTagBindServiceImpl extends ServiceImpl<ArticleTagBindMapper, ArticleTagBind> implements IArticleTagBindService {

    private final ArticleTagBindMapper articleTagBindMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public ArticleTagBindServiceImpl(ArticleTagBindMapper articleTagBindMapper) {
        this.articleTagBindMapper = articleTagBindMapper;
    }

    @Override
    public Page<ArticleSummaryDto> queryPagedArticleSummary(PaginationDto<ArticleSummaryDto> condition) throws IllegalAccessException {
        return articleTagBindMapper.queryPagedArticleSummary(condition.getPage(), QueryWrapperUtil.parseWhereSql(condition.getConditionList(), new ArticleSummaryDto()));
    }
}
