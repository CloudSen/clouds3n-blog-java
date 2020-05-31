package com.clouds3n.blog.common.utils;

import com.clouds3n.blog.common.SysCode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author CloudS3n
 * @date 2019/5/22 11:12
 */
public class LocalUtils {

    /**
     * @return yyyyMMdd
     */
    public static String getSimpleDate() {
        return formatLocalDateTime(LocalDateTime.now(), SysCode.DATE_FORMAT_STR8);
    }

    /**
     * @return current local date time
     */
    public static String now() {
        return formatLocalDateTime(LocalDateTime.now());
    }

    /**
     * @param time LocalDateTime
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String formatLocalDateTime(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern(SysCode.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
    }

    /**
     * @param time    LocalDateTime
     * @param pattern 时间格式
     * @return 格式化后的LocalDateTime
     */
    public static String formatLocalDateTime(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }
}
