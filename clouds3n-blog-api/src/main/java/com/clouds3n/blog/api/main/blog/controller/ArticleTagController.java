package com.clouds3n.blog.api.main.blog.controller;


import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.common.entity.ArticleTag;
import com.clouds3n.blog.common.service.IArticleTagService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 文章标签表 前端控制器
 * </p>
 *
 * @author CloudS3n
 * @since 2020-02-18
 */
@RestController
@RequestMapping("/main/blog/article-tag")
public class ArticleTagController {

    private final IArticleTagService tagService;

    public ArticleTagController(IArticleTagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public Res listAll() {
        return Res.ok(tagService.list());
    }

    @PostMapping
    public Res saveOrUpdate(@RequestBody @Validated ArticleTag articleTag) {
        tagService.saveOrUpdate(articleTag);
        return Res.ok(articleTag.getUuid());
    }

    @PostMapping("/batch-save-update")
    public Res batchSaveOrUpdate(@RequestBody @Validated List<ArticleTag> articleTags) {
        tagService.saveOrUpdateBatch(articleTags);
        return Res.ok(articleTags.stream().map(ArticleTag::getUuid).toArray());
    }
}
