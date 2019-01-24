package com.xxx.brixton.common.constant;

import lombok.Data;

/**
 * 定义返回数据类
 */
@Data
public class Response<T> {

    private Integer code;
    private String message;
    private T data;

    public static final Integer CODE_SUCCESS = 200;
    public static final Integer CODE_SERVER_ERROR = 500;

    public Response() {}

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Response success() {
        return new Response(Response.CODE_SUCCESS, "SUCCESS");
    }

    public static <T> Response success(T data) {
        return new Response<T>(Response.CODE_SUCCESS, "SUCCESS", data);
    }

    public static Response fail() {
        return new Response(Response.CODE_SERVER_ERROR, "FAILED");
    }

}
