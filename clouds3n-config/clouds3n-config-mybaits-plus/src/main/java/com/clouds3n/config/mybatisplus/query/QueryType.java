package com.clouds3n.config.mybatisplus.query;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author CloudS3n
 * @date 2020-01-12 20:03
 */
public enum QueryType {
    /**
     * 全等
     */
    EQ("eq"),
    /**
     * 不等
     */
    NE("ne"),
    /**
     * 全模糊匹配查询
     */
    LIKE("like"),
    /**
     * 左模糊匹配查询
     */
    LEFT_LIKE("leftLike"),
    /**
     * 右模糊匹配查询
     */
    RIGHT_LIKE("rightLike"),
    /**
     * 全模糊不匹配查询
     */
    NOT_LIKE("notLike"),
    /**
     * 大于
     */
    GT("gt"),
    /**
     * 小于
     */
    LT("lt"),
    /**
     * 大于等于
     */
    GE("ge"),
    /**
     * 小于等于
     */
    LE("le"),
    ;

    @JsonValue
    private final String name;

    public String getName() {
        return name;
    }

    QueryType(String name) {
        this.name = name;
    }

    public static QueryType parseQueryType(String name) {
        return Arrays.stream(values())
            .filter(queryType -> queryType.getName().equalsIgnoreCase(name))
            .findAny().orElseThrow(() -> new IllegalArgumentException("无法解析搜索类型" + name));
    }
}
