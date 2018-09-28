package com.example.girl.handle;

import com.example.girl.controller.GirlController;
import com.example.girl.domain.Result;
import com.example.girl.exception.GirlExcepion;
import com.example.girl.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice  //用于拦截全局的Controller的异常,不会拦截Interceptor的异常
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
       if(e instanceof GirlExcepion){
           GirlExcepion girlExcepion = (GirlExcepion) e;
           return ResultUtils.error(girlExcepion.getCode(),girlExcepion.getMessage());
       }else {
           logger.info("[系统异常]{}",e);
           return ResultUtils.error(-1,"未知错误");
       }
    }
}
