package com.kfm.system.ex;

import com.kfm.system.util.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author yangbohan
 * @Date 2023/12/19 22:24
 */
@RestControllerAdvice
public class MyExceltionHandler {
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        if (StringUtils.hasText(e.getMessage())){
            return Result.error(e.getMessage());
        }
        return Result.error("服务器发生错误，请重试");
    }
}
