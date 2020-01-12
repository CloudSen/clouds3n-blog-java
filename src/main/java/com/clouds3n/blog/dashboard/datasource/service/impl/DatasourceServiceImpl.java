package com.clouds3n.blog.dashboard.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.dashboard.datasource.entity.Datasource;
import com.clouds3n.blog.dashboard.datasource.mapper.DatasourceMapper;
import com.clouds3n.blog.dashboard.datasource.service.IDatasourceService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 动态数据源 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-01-12
 */
@Service
public class DatasourceServiceImpl extends ServiceImpl<DatasourceMapper, Datasource> implements IDatasourceService {

}
