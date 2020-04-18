package com.clouds3n.blog.api.main.aboutme.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.api.main.aboutme.entity.AboutMe;
import com.clouds3n.blog.api.main.aboutme.mapper.AboutMeMapper;
import com.clouds3n.blog.api.main.aboutme.service.IAboutMeService;
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
