package com.lyf.common;

/**
 * Created by Quincy on 2018/3/6.
 */
public enum  ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"这是一个小学生哦"),
    AGE_ERROR(2,"年龄太小了！");


    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
