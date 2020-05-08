package com.clouds3n.config.mybatisplus.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author CloudS3n
 * @date 2020-04-19 14:25
 */
@Data
@Accessors(chain = true)
public class PaginationDto<T> implements Serializable {
    private static final long serialVersionUID = 4289610998417783140L;
    /**
     * 分页参数
     */
    Page<T> page;
    /**
     * 查询条件
     */
    List<QueryConditionDto> conditionList;
}
