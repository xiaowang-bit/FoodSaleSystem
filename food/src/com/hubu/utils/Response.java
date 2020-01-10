package com.hubu.utils;

import com.hubu.Enum.ResponseEnum;

import java.util.HashMap;
import java.util.Map;

//统一的返回类
public class Response {
    private int code;  //返回码
    private String message;   //返回描述
    private Map<String,Object> map= new HashMap<>();   //返回数据

    //返回方法
    public static Response response(ResponseEnum responseEnum){
        Response response=new Response();
        response.setCode(responseEnum.getCode());
        response.setMessage(responseEnum.getMessage());
        return response;
    }

    //添加数据方法
    public  Response add(String key,Object object){
        this.getMap().put(key,object);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
