package com.clouds3n.blog.dashboard.datasource.controller;


import com.clouds3n.blog.dashboard.datasource.service.IDatasourceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 动态数据源 前端控制器
 * </p>
 *
 * @author CloudS3n
 * @since 2020-01-12
 */
@RestController
@RequestMapping("/dashboard/datasource")
public class DatasourceController {

    private final IDatasourceService datasourceService;

    public DatasourceController(IDatasourceService datasourceService) {
        this.datasourceService = datasourceService;
    }


}
