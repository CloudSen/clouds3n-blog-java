package com.clouds3n.blog.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author CloudS3n
 * @date 2020-01-12 0:59
 */
class UUIDUtilTest {

    @Test
    void uuid() {
        String uuid = UUIDUtil.uuid();
        Assertions.assertNotNull(uuid);
        Assertions.assertEquals(36, uuid.length());
    }

    @Test
    void uuid32() {
        String uuid32 = UUIDUtil.uuid32();
        Assertions.assertNotNull(uuid32);
        Assertions.assertEquals(32, uuid32.length());
    }
}
