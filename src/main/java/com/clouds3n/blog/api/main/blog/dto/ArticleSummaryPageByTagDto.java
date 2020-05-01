package com.clouds3n.blog.api.main.blog.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>文章摘要分页查询</p>
 * <p>通过标签id作为查询条件</p>
 *
 * @author CloudS3n
 * @date 2020-05-01 15:59
 */
@Data
@Accessors(chain = true)
public class ArticleSummaryPageByTagDto {
    private Page<ArticleSummaryDto> page;
    private String tagId;
}
