package com.dnd.base.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author zhangxy
 * @date 2020/01/09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -440428047248005850L;
    private T data;
    private String rspCode;
    private String rspMsg;
    public static <T> Result<T> succeed() {
        return succeedWith(null, "00", "调用成功");
    }

    public static <T> Result<T> succeed(String msg) {
        return succeedWith(null, "00", msg);
    }

    public static <T> Result<T> succeed(T model, String msg) {
        return succeedWith(model, "00", msg);
    }

    public static <T> Result<T> succeed(T model) {
        return succeedWith(model, "00", "调用成功");
    }

    public static <T> Result<T> succeedWith(T datas, String code, String msg) {
        return new Result<>(datas, code, msg);
    }

    public static <T> Result<T> failed() {
        return failedWith(null, "01", "调用失败");
    }

    public static <T> Result<T> failed(String msg) {
        return failedWith(null, "01", msg);
    }

    public static <T> Result<T> failed(T model, String msg) {
        return failedWith(model, "01", msg);
    }

    public static <T> Result<T> failedWith(T datas, String code, String msg) {
        return new Result<>(datas, code, msg);
    }

}
