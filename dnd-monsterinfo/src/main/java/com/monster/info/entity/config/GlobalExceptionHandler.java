package com.monster.info.entity.config;


import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.dnd.base.api.response.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * <b>GlobalExceptionHandler</b> is 全局异常处理类
 * </p>
 *
 * @author ZhangHan qu
 * @date 2021/9/22 16:46
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({IllegalArgumentException.class})
    public Result customExceptionHandler(Exception e) {
        return Result.failed(e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result paramsExceptionHandler(MethodArgumentNotValidException e) {
        e.printStackTrace();
//        return Result.failed("参数校验未通过");
        //return Result.failed(e.getBindingResult().getFieldError().getDefaultMessage());
        return Result.failed("参数校验未通过:"+e.getBindingResult().getFieldError().getField()+e.getBindingResult().getFieldError().getDefaultMessage());

    }

    @ExceptionHandler({Exception.class})
    public Result ExceptionHandler(Exception e) {
        e.printStackTrace();
        return Result.failed("内部错误");
    }
    @ExceptionHandler({ApiException.class})
    public Result ApiException(Exception e) {
        e.printStackTrace();
        return Result.failed(e.getMessage());
    }}
