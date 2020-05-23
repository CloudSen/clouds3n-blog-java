package com.clouds3n.blog.dashboard.datasource;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.common.entity.DruidProperties;
import com.clouds3n.blog.common.service.IDruidPropertiesService;
import com.clouds3n.blog.common.utils.QueryWrapperUtil;
import com.clouds3n.config.mybatisplus.query.QueryConditionDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * Druid参数 前端控制器
 * </p>
 *
 * @author CloudS3n
 * @since 2020-01-12
 */
@RestController
@RequestMapping("/dashboard/datasource/druid-properties")
public class DruidPropertiesController {

    private final IDruidPropertiesService druidPropertiesService;

    public DruidPropertiesController(IDruidPropertiesService druidPropertiesService) {
        this.druidPropertiesService = druidPropertiesService;
    }

    @PostMapping("/query")
    public Res query(@RequestBody @Validated List<QueryConditionDto> conditionList) throws IllegalAccessException {
        return Res.ok(druidPropertiesService.list(QueryWrapperUtil.parseWhereSql(conditionList, new DruidProperties())));
    }

    @PostMapping("/page")
    public Res queryPage(Page<DruidProperties> page, List<QueryConditionDto> conditionList) throws IllegalAccessException {
        return Res.ok(druidPropertiesService.page(page, QueryWrapperUtil.parseWhereSql(conditionList, new DruidProperties())));
    }

    @PostMapping
    public Res saveOrUpdate(@RequestBody @Validated DruidProperties druidProperties) {
        druidPropertiesService.saveOrUpdate(druidProperties);
        return Res.ok(druidProperties.getUuid());
    }
}
