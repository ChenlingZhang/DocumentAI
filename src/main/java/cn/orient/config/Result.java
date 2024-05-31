package cn.orient.config;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.code = 200;
        return result;
    }

    public static <T> Result<T> fail(T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.code = 500;
        return result;
    }
}
