package com.clouds3n.blog.common.dto;

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
    Page<T> page;
    List<QueryConditionDto> conditionList;
}
