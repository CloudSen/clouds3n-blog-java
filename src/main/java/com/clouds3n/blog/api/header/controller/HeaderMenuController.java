package com.clouds3n.blog.api.header.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.clouds3n.blog.api.header.entity.HeaderMenu;
import com.clouds3n.blog.api.header.service.IHeaderMenuService;
import com.clouds3n.blog.common.Res;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * header简单菜单 前端控制器
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-18
 */
@RestController
@RequestMapping("/header/header-menu")
public class HeaderMenuController {

    private final IHeaderMenuService headerMenuService;

    public HeaderMenuController(IHeaderMenuService headerMenuService) {
        this.headerMenuService = headerMenuService;
    }

    @GetMapping
    public Res getMenuList() {
        LambdaQueryWrapper<HeaderMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(HeaderMenu::getItemOrder);
        return Res.ok(headerMenuService.list(wrapper));
    }
}
