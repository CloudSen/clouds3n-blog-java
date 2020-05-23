package com.clouds3n.blog.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 驼峰转下划线
 *
 * @author CloudS3n
 */
public class ColumnUtil {

    public static String toDbColumn(String field) {
        if (StringUtils.isNotBlank(field)) {
            StringBuilder buffer = new StringBuilder();
            char[] arr = field.toCharArray();
            List<Integer> insertIndex = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if (i != 0 && Character.isUpperCase(c)) {
                    insertIndex.add(i);
                }
            }
            if (insertIndex.size() > 0) {
                int startIndex = 0;
                for (Integer index : insertIndex) {
                    String word = lowercaseFirstLetter(field.substring(startIndex, index));
                    buffer.append(word).append("_");
                    startIndex = index;
                }
                String last = lowercaseFirstLetter(field.substring(startIndex));
                buffer.append(last);
                return buffer.toString();
            }
        }
        return field;
    }

    private static String lowercaseFirstLetter(String word) {
        if (StringUtils.isNotBlank(word) && word.length() > 1) {
            String firstLetter = word.substring(0, 1);
            String others = word.substring(1);
            return firstLetter.toLowerCase() + others;
        }
        return word;
    }
}
