package com.clouds3n.blog.dashboard.articlemgmt;

import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.common.service.ITopicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 专题管理
 *
 * @author CloudS3n
 * @date 2020-05-29 21:30
 */
@RestController
@RequestMapping("/topic")
public class TopicMgmtController {

    private final ITopicService topicService;

    public TopicMgmtController(ITopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/sub-topic")
    public Res getAllSubTopicList() {
        return Res.ok(topicService.getAllSubTopicList());
    }
}
