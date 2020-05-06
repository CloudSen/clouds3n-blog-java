package com.clouds3n.blog.common.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clouds3n.blog.common.entity.ArticleTagBind;
import com.clouds3n.blog.common.service.dto.ArticleSummaryDto;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 文章-标签多对多关系表 Mapper 接口
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
public interface ArticleTagBindMapper extends BaseMapper<ArticleTagBind> {

    /**
     * <p>查询文章摘要列表</p>
     * <p>自定义条件分页查询</p>
     *
     * @param page    分页参数
     * @param wrapper 查询条件wrapper
     * @return 分页后的文章列表
     */
    Page<ArticleSummaryDto> queryPagedArticleSummary(Page<ArticleSummaryDto> page, @Param(Constants.WRAPPER) QueryWrapper<ArticleSummaryDto> wrapper);
}
