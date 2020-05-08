package com.clouds3n.blog.common.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author CloudS3n
 * @date 2020-04-19 0:22
 */
@SuppressWarnings("rawtypes")
public class OptionalUtil {

    public static <T> Optional<T> ofCollectionEmptiable(T value) {
        if (value == null) {
            return Optional.empty();
        }
        if (!(value instanceof Collection)) {
            throw new IllegalArgumentException("不支持的类型");
        }
        return CollectionUtils.isEmpty((Collection) value) ? Optional.empty() : Optional.of(value);
    }

    public static <T> Optional<T> ofEmptiableQueue(T value) {
        if (value == null) {
            return Optional.empty();
        }
        if (!(value instanceof Queue)) {
            throw new IllegalArgumentException("请传入Queue");
        }
        return ((Queue) value).size() == 0 ? Optional.empty() : Optional.of(value);
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("sdf", "sf");
        List<String> strings2 = new ArrayList<>();
        List<String> strings3 = null;
        Map<String, String> map1 = new HashMap<>(16);
        OptionalUtil.ofCollectionEmptiable(strings).orElseThrow(() -> new IllegalArgumentException("集合为空"));
        OptionalUtil.ofCollectionEmptiable(strings2).orElseThrow(() -> new IllegalArgumentException("集合为空"));
        OptionalUtil.ofCollectionEmptiable(strings3).orElseThrow(() -> new IllegalArgumentException("集合为null"));
        OptionalUtil.ofCollectionEmptiable(map1).orElseThrow(() -> new IllegalArgumentException("集合为空"));

        LinkedBlockingQueue<String> queue1 = new LinkedBlockingQueue<>(3);
        queue1.add("1");
        queue1.add("2");
        queue1.add("3");
        LinkedBlockingQueue<String> queue2 = new LinkedBlockingQueue<>(3);
        LinkedBlockingQueue<String> queue3 = null;
        OptionalUtil.ofEmptiableQueue(queue1).orElseThrow(() -> new IllegalArgumentException("队列1为空"));
        OptionalUtil.ofEmptiableQueue(queue2).orElseThrow(() -> new IllegalArgumentException("队列2为空"));
        OptionalUtil.ofEmptiableQueue(queue3).orElseThrow(() -> new IllegalArgumentException("队列3为空"));
    }
}
