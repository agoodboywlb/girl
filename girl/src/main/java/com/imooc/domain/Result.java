package com.imooc.domain;
//请求返回的最外层对象
public class Result<T> {
    private Integer code;
    private String msg;
    private T date;

    public Result() {
    }

    public Result(Integer code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
