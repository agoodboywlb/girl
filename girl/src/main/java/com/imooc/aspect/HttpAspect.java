package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {
    private final static org.slf4j.Logger loger= org.slf4j.LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    public void log(){
        System.out.println("11111111");
    }
    @Before("log()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =requestAttributes.getRequest();
        //获取URL
        loger.info("url={}",request.getRequestURL());
        //ip
        loger.info("ip={}",request.getRemoteAddr());
        //method
        loger.info("method={}",request.getMethod());
        //方法参数
        loger.info("args={}",joinPoint.getArgs());
        //类方法
        loger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
    }
    @After("log()")
    public void after(){

    }
    //返回请求相应的对象
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        loger.info("response={}",object.toString());
    }
}
