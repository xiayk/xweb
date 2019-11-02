package com.xiayk.api.common;

/**
 * @ClassName XException
 * @Author XiaYk
 * @Date 2019-05-23 12:33
 * @Version 1.0
 */
public class XException extends RuntimeException  {

    public XException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
