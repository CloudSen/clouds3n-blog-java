package com.clouds3n.config.core.exception;

import com.clouds3n.blog.common.dto.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 * @author CloudS3n
 * @date 2020-04-19 14:30
 */
@Slf4j
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String SERVER_ERROR = "服务端错误";

    @ExceptionHandler(BusinessException.class)
    public Res businessExceptionHandler(BusinessException e, WebRequest request) {
        log.error(request.getContextPath());
        log.error(ExceptionUtils.getStackTrace(e));
        return Res.error(StringUtils.isBlank(e.getMessage()) ? SERVER_ERROR : e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Res validationExceptionHandler(MethodArgumentNotValidException e) {
        log.error(ExceptionUtils.getStackTrace(e));
        StringBuilder msg = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(error -> msg.append(error.getDefaultMessage()).append(","));
        return Res.error(StringUtils.isBlank(msg.toString()) ? SERVER_ERROR : msg.toString());
    }

    @ExceptionHandler(Exception.class)
    public Res otherExceptionHandler(Exception e) {
        log.error(ExceptionUtils.getStackTrace(e));
        String msg = e.getCause().getMessage();
        if (StringUtils.isBlank(msg)) {
            msg = SERVER_ERROR;
        }
        return Res.error(msg);
    }
}
