package com.clouds3n.blog.common.utils;

import com.clouds3n.blog.common.SysCode;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * UUID generator util
 *
 * @author CloudS3n
 * @date 2020-01-12 0:53
 */
public final class UUIDUtil {

    /**
     * get 36 length of UUID
     *
     * @return String UUID
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * get 32 length of UUID
     *
     * @return String UUID
     */
    public static String uuid32() {
        return uuid().replaceAll(SysCode.SHORT_DASH, StringUtils.EMPTY);
    }

    public static void main(String[] args) {
        System.out.println(uuid32());
    }

}
