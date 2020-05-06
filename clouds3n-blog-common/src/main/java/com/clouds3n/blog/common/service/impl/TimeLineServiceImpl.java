package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.entity.TimeLine;
import com.clouds3n.blog.common.mapper.TimeLineMapper;
import com.clouds3n.blog.common.service.ITimeLineService;
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
