package com.clouds3n.blog.dashboard.monitor.controller;

import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.dashboard.monitor.service.MonitorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CloudS3n
 * @date 2020-05-31 13:18
 */
@RestController
@RequestMapping("/monitor")
public class MonitorController {

    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping("")
    public Res getMonitorData() {
        return Res.ok(monitorService.getMonitorData());
    }

    @GetMapping("/card-data")
    public Res getMonitorCardData() {
        return Res.ok(monitorService.getMonitorCardData());
    }

    @GetMapping("/tag-pie-data")
    public Res getTagPieData() {
        return Res.ok(monitorService.getTagPieData());
    }
}
