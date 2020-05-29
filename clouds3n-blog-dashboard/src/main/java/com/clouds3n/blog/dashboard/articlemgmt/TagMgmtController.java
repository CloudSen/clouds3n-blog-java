package com.clouds3n.blog.dashboard.articlemgmt;

import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.common.service.IArticleTagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CloudS3n
 * @date 2020-05-29 21:31
 */
@RestController
@RequestMapping("/tag")
public class TagMgmtController {

    private final IArticleTagService tagService;

    public TagMgmtController(IArticleTagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("")
    public Res getAllTagList() {
        return Res.ok(tagService.getAllTagList());
    }
}
