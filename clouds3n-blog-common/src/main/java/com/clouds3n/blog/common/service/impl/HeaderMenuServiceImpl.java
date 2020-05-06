package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.entity.HeaderMenu;
import com.clouds3n.blog.common.mapper.HeaderMenuMapper;
import com.clouds3n.blog.common.service.IHeaderMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * header简单菜单 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-18
 */
@Service
public class HeaderMenuServiceImpl extends ServiceImpl<HeaderMenuMapper, HeaderMenu> implements IHeaderMenuService {

}
