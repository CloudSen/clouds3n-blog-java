package com.clouds3n.blog.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Optional;

/**
 * @author CloudS3n
 * @date 2020-04-19 0:22
 */
@SuppressWarnings("rawtypes")
public class OptionalUtil {

    public static <T> Optional<T> ofCollectionNullable(T value) {
        if (!(value instanceof Collection)) {
            throw new IllegalArgumentException("不支持的类型");
        }
        return CollectionUtils.isEmpty((Collection) value) ? Optional.empty() : Optional.of(value);
    }
}
