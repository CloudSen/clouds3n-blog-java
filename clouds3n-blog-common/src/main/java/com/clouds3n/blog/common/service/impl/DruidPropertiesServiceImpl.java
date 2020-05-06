package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.entity.DruidProperties;
import com.clouds3n.blog.common.mapper.DruidPropertiesMapper;
import com.clouds3n.blog.common.service.IDruidPropertiesService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Druid参数 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-01-12
 */
@Service
public class DruidPropertiesServiceImpl extends ServiceImpl<DruidPropertiesMapper, DruidProperties> implements IDruidPropertiesService {

}
