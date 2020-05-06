package com.clouds3n.blog.common.dto;

import com.clouds3n.blog.common.SysCode;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 全局统一返回类
 *
 * @author CloudS3n
 * @date 2020-01-12 3:04
 */
@Data
@Accessors(chain = true)
public class Res implements Serializable {

    private static final long serialVersionUID = -9160393812508951673L;
    private Boolean success = true;
    private Integer code = 200;
    private String msg = SysCode.OPERATION_SUCCESS;
    private Object data = null;

    public static Res ok() {
        return new Res();
    }

    public static Res ok(Object data) {
        return new Res().setData(data);
    }

    public static Res error() {
        return new Res().setSuccess(Boolean.FALSE)
            .setCode(500)
            .setMsg(SysCode.OPERATION_FAILED);
    }

    public static Res error(Object data) {
        return new Res().setSuccess(Boolean.FALSE)
            .setCode(500)
            .setMsg(SysCode.OPERATION_FAILED)
            .setData(data);
    }

    public static Res error(Integer code, String msg) {
        return new Res().setSuccess(Boolean.FALSE)
            .setCode(code == null ? 500 : code)
            .setMsg(StringUtils.isBlank(msg) ? SysCode.OPERATION_FAILED : msg);
    }

    public static Res error(Integer code, String msg, Object data) {
        return new Res().setSuccess(Boolean.FALSE)
            .setCode(code == null ? 500 : code)
            .setMsg(StringUtils.isBlank(msg) ? SysCode.OPERATION_FAILED : msg)
            .setData(data);
    }
}
