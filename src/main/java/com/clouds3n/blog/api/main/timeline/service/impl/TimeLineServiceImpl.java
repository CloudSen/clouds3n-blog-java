package com.clouds3n.blog.api.main.timeline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.api.main.timeline.entity.TimeLine;
import com.clouds3n.blog.api.main.timeline.mapper.TimeLineMapper;
import com.clouds3n.blog.api.main.timeline.service.ITimeLineService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 时间轴 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@Service
public class TimeLineServiceImpl extends ServiceImpl<TimeLineMapper, TimeLine> implements ITimeLineService {

}
