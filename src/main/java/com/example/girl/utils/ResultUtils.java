package com.example.girl.utils;

import com.example.girl.domain.Result;

public class ResultUtils {

    public static Result success(Object Object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(Object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String message){//如果失败传递两个参数进来
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }


}
