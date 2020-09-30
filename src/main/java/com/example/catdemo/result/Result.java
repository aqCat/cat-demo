package com.example.catdemo.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    /****************************构造函数********************************/

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /****************************静态方法********************************/

    public static  <T> Result<T> success(){
        Result<T> result = new Result<>(ResultCode.SUCCESS);
        return result;
    }

    public static  <T> Result<T> success(T data){
        Result<T> result = new Result<>(ResultCode.SUCCESS, data);
        return result;
    }

    public static  <T> Result<T> error(ResultCode resultCode){
        Result<T> result = new Result<>(resultCode);
        return result;
    }

    public static  <T> Result<T> error(ResultCode resultCode, T data){
        Result<T> result = new Result<>(resultCode, data);
        return result;
    }

    public static  <T> Result<T> error(Integer code, String message){
        Result<T> result = new Result<>(code, message);
        return result;
    }
}
