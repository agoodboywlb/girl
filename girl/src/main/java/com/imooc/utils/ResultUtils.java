package com.imooc.utils;

import com.imooc.domain.Result;

public class ResultUtils {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setDate(object);
        return result;
    }
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setDate(null);
        return result;
    }
}
