package com.clouds3n.blog.common;

import com.clouds3n.blog.common.enums.QueryType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @author CloudS3n
 * @date 2020-01-12 19:53
 */
@Data
@Accessors(chain = true)
public class QueryConditionDto {
    /**
     * 数据库字段名
     */
    @NotBlank
    private String column;

    /**
     * 字段值
     */
    @NotBlank
    private String value;

    /**
     * <p>条件类型</p>
     * <p>eq: 全等</p>
     * <p>like: 全模糊匹配查询</p>
     * <p>leftLike: 左模糊匹配查询</p>
     * <p>rightLike: 右模糊匹配查询</p>
     * <p>notLike: 全模糊不匹配查询</p>
     * <p>gt: 大于</p>
     * <p>lt: 小于</p>
     * <p>ge: 大于等于</p>
     * <p>le: 小于等于</p>
     */
    @NotBlank
    private QueryType queryType;
}
