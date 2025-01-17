package com.zjt.server.entity;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

//返回前端code、data、message
public record RestBean<T>(int code, T data, String message) {
    public static <T> RestBean<T> success(T data){
        return new RestBean<>(200, data, "请求成功");
    }
    public static <T> RestBean<T> success(T data, String message){
        return new RestBean<>(200, data, message);
    }

    public static <T> RestBean<T> success(){
        return success(null);
    }

    public static <T> RestBean<T> failure(int code, String message){
        return new RestBean<>(code, null, message);
    }

    public static <T> RestBean<T> unauthorized(int code, String message){
        return new RestBean<>(code, null, message);
    }

    public static <T> RestBean<T> forbidden(int code, String message){
        return new RestBean<>(code, null, message);
    }

    public String asJsonString(){
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
}
