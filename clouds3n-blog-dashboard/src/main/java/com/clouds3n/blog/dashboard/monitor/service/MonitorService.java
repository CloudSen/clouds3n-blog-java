package com.clouds3n.blog.dashboard.monitor.service;

import com.clouds3n.blog.dashboard.monitor.dto.MonitorCardDto;
import com.clouds3n.blog.dashboard.monitor.dto.MonitorDataDto;

import java.util.List;

/**
 * @author CloudS3n
 * @date 2020-05-31 13:21
 */
public interface MonitorService {

    /**
     * 获取系统监视数据
     *
     * @return MonitorDataDto
     */
    MonitorDataDto getMonitorData();

    /**
     * 获取监视卡片数据
     *
     * @return MonitorCardDto列表
     */
    List<MonitorCardDto> getMonitorCardData();
}
