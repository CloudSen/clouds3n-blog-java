package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.entity.Datasource;
import com.clouds3n.blog.common.mapper.DatasourceMapper;
import com.clouds3n.blog.common.service.IDatasourceService;
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
