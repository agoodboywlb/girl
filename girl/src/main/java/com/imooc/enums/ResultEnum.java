package com.imooc.enums;

public enum ResultEnum {
    UNKONWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    ERROR_ONE(1000,"你是小学生吧"),
    ERROR_TWO(1001,"你是中学生")
    ;
    private String msg;
    private Integer code;

    ResultEnum( Integer code,String msg) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
