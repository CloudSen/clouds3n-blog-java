package com.clouds3n.blog.dashboard.monitor.service;

import com.clouds3n.blog.dashboard.monitor.dto.MonitorCardDto;
import com.clouds3n.blog.dashboard.monitor.dto.MonitorDataDto;
import com.clouds3n.blog.dashboard.monitor.dto.TagPieDataDto;

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

    /**
     * 标签饼图数据
     *
     * @return 每个标签的文章总数
     */
    List<TagPieDataDto> getTagPieData();
}
