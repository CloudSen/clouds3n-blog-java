package com.clouds3n.blog.api.aside.controller;


import com.clouds3n.blog.api.aside.entity.DrawerMenu;
import com.clouds3n.blog.api.aside.service.IDrawerMenuService;
import com.clouds3n.blog.common.Res;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 抽屉菜单 前端控制器
 * </p>
 *
 * @author CloudS3n
 * @since 2020-02-18
 */
@RestController
@RequestMapping("/aside/drawer-menu")
public class DrawerMenuController {

    private final IDrawerMenuService drawerMenuService;

    public DrawerMenuController(IDrawerMenuService drawerMenuService) {
        this.drawerMenuService = drawerMenuService;
    }

    @GetMapping
    public Res listAll() {
        return Res.ok(drawerMenuService.list());
    }

    @PostMapping
    public Res saveOrUpdate(@RequestBody @Validated DrawerMenu drawerMenu) {
        drawerMenuService.saveOrUpdate(drawerMenu);
        return Res.ok(drawerMenu.getUuid());
    }

    @PostMapping("/batch-save-update")
    public Res batchSaveOrUpdate(@RequestBody @Validated List<DrawerMenu> drawerMenus) {
        drawerMenuService.saveOrUpdateBatch(drawerMenus);
        return Res.ok(drawerMenus.stream().map(DrawerMenu::getUuid).toArray());
    }

}
