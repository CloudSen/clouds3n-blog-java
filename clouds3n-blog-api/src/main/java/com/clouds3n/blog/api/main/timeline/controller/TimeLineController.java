package com.clouds3n.blog.api.main.timeline.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.common.entity.TimeLine;
import com.clouds3n.blog.common.service.ITimeLineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 时间轴 前端控制器
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@RestController
@RequestMapping("/main/time-line")
public class TimeLineController {

    private final ITimeLineService timeLineService;

    public TimeLineController(ITimeLineService timeLineService) {
        this.timeLineService = timeLineService;
    }

    @GetMapping("")
    public Res getTimeLine() {
        LambdaQueryWrapper<TimeLine> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(TimeLine::getCreateTime);
        return Res.ok(timeLineService.list(wrapper));
    }
}
