package com.example.girl.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.girl.controller.GirlController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("calss_method={}",joinPoint.getSignature().getDeclaringTypeName() +"."+ joinPoint.getSignature().getName());//获取类名和类方法
        //类参数
        logger.info("args={}",joinPoint.getArgs());


        logger.info("哈哈哈哈哈哈");
    }
    @After("log()")
    public void doAfter(){
        logger.info("哦哦哦哦哦哦");
    }

    //获取我们返回的内容
    @AfterReturning(returning = "object",pointcut = "log()")
    public void  doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }



}
