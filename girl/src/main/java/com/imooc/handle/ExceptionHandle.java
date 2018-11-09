package com.imooc.handle;

import com.imooc.domain.Result;
import com.imooc.exception.GirlException;
import com.imooc.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//ControllerAdvice注解只拦截Controller不会拦截Interceptor的异常
@ControllerAdvice
public class ExceptionHandle {
   private final static Logger logger=LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    //处理后返回为json格式
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException=(GirlException) e;
            return ResultUtils.error(girlException.getCode(),girlException.getMessage());
        }
        logger.info("[未知错误]={}",e);
        return ResultUtils.error(-1,"未知错误");
    }
}
