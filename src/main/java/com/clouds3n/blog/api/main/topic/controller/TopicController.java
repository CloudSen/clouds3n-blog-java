package com.clouds3n.blog.api.main.topic.controller;


import com.clouds3n.blog.api.main.topic.service.ITopicService;
import com.clouds3n.blog.common.Res;
import org.springframework.web.bind.annotation.GetMapping;
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

    public TopicController(ITopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("")
    public Res getAll() {
        return Res.ok(topicService.buildTopicList());
    }
}
