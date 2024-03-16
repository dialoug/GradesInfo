package com.study.gradesInfo.entity.utils;

import com.github.pagehelper.util.StringUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtil.isNotEmpty(e.getMessage()) ? e.getMessage() : "操作失败");
    }
}
