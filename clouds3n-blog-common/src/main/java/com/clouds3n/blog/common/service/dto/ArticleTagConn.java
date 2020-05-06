package com.clouds3n.blog.common.service.dto;

import com.clouds3n.blog.common.entity.ArticleTag;
import com.clouds3n.blog.common.entity.ArticleTagBind;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 文章和标签关联关系
 *
 * @author CloudS3n
 * @date 2020-05-02 0:09
 */
@Data
@Accessors(chain = true)
public class ArticleTagConn {
    private ArticleSummaryDto articleSummaryDto;
    private List<ArticleTagDto> articleTagDtoList;

    public void saveTagIdList(Map<String, List<ArticleTagBind>> articleTagBindMap) {
        List<ArticleTagDto> tagList = new ArrayList<>();
        articleTagBindMap.forEach((articleId, articleTagBinds) -> {
            if (StringUtils.equals(articleId, articleSummaryDto.getUuid())) {
                articleTagBinds.forEach(articleTagBind -> tagList.add(new ArticleTagDto().setUuid(articleTagBind.getTagId())));
            }
        });
        this.articleTagDtoList = tagList;
    }

    public void saveTagDetailList(List<ArticleTag> tagList) {
        this.articleTagDtoList = tagList.stream()
            .filter(articleTag -> this.articleTagDtoList.stream().map(ArticleTagDto::getUuid).collect(Collectors.toList()).contains(articleTag.getUuid()))
            .map(ArticleTag::toArticleTagDto)
            .collect(Collectors.toList());
    }
}
