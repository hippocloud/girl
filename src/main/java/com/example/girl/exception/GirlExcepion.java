package com.example.girl.exception;

import com.example.girl.enums.ResultEnum;

/**
 * 这里只有code，没有message
 */
public class GirlExcepion extends RuntimeException {//这里为什么是runtimeException呢？是因为这个才会有事务回滚，而Excepton不会事务回滚

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {

        this.code = code;
    }

    public GirlExcepion(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
