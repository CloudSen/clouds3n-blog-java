package com.clouds3n.blog.api.main.topic.controller;


import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.common.service.ITopicArticleBindService;
import com.clouds3n.blog.common.service.ITopicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 专题 前端控制器
 * </p>
 *
 * @author CloudS3n
 * @since 2020-05-02
 */
@RestController
@RequestMapping("/main/topic")
public class TopicController {

    private final ITopicService topicService;
    private final ITopicArticleBindService topicArticleBindService;

    public TopicController(ITopicService topicService, ITopicArticleBindService topicArticleBindService) {
        this.topicService = topicService;
        this.topicArticleBindService = topicArticleBindService;
    }

    @GetMapping("")
    public Res getAll() {
        return Res.ok(topicService.buildTopicList());
    }

    @GetMapping("/{topicId}")
    public Res getArticlesByTopicId(@PathVariable("topicId") String topicId) {
        return Res.ok(topicArticleBindService.getArticlesByTopicId(topicId));
    }
}
