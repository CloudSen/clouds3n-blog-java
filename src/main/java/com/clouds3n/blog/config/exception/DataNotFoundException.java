package com.clouds3n.blog.config.exception;

/**
 * 没有查询到数据异常
 *
 * @author CloudS3n
 * @date 2019/12/20 15:17
 */
public class DataNotFoundException extends BusinessException {
    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(Integer code) {
        super(code);
    }

    public DataNotFoundException(String message, Integer code) {
        super(message, code);
    }

    public DataNotFoundException(String message, Throwable cause, Integer code) {
        super(message, cause, code);
    }

    public DataNotFoundException(Throwable cause, Integer code) {
        super(cause, code);
    }

    public DataNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace, code);
    }
}
