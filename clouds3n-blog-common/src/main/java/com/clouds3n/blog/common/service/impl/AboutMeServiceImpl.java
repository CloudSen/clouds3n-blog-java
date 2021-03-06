package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.entity.AboutMe;
import com.clouds3n.blog.common.mapper.AboutMeMapper;
import com.clouds3n.blog.common.service.IAboutMeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关于我 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@Service
public class AboutMeServiceImpl extends ServiceImpl<AboutMeMapper, AboutMe> implements IAboutMeService {

}
