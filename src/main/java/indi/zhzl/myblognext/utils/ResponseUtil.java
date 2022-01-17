package indi.zhzl.myblognext.utils;

import indi.zhzl.myblognext.pojo.vo.Result;

import java.util.HashMap;

public class ResponseUtil {
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(200, message, data);
    }

    public static Result<Object> success(String message) {
        return new Result<>(200, message, new HashMap<>());
    }

    public static Result<Object> fail(String message) {
        return new Result<>(400, message, new HashMap<>());
    }

    public static Result<Object> error(String message) {
        return new Result<>(500, message, new HashMap<>());
    }
}
