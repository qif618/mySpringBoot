package com.lyf.exception;

import com.lyf.common.ResponseCode;

public class MyException extends RuntimeException{
    private Integer code;

    public MyException(ResponseCode responseCode) {
        super(responseCode.getDesc());
        this.code = responseCode.getCode();
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}