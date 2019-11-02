package com.xiayk.api.common;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName RestResult
 * @Author XiaYk
 * @Date 2019-04-24 17:44
 * @Version 1.0
 */
public class RestResult {
    /**
     * 请求是否成功
     */
    private boolean success;
    /**
     * 成功或者失败的code错误码
     */
    private Integer code;
    /**
     * 成功时返回的数据，失败时返回具体的异常信息
     */
    private Object data;
    /**
     * 请求失败返回的提示信息，给前端进行页面展示的信息
     */
    private Object errorMessage;
    /**
     * 服务器当前时间（添加该字段的原因是便于查找定位请求时间，因为实际开发过程中服务器时间可能跟本地时间不一致，加上这个时间戳便于日后定位）
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date currentTime;

    public RestResult() {
    }


    public RestResult(boolean success, Integer code, Object data, Object errorMessage) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.errorMessage = errorMessage;
        this.currentTime = new Date();
    }

    public static RestResult ResultOk(Object data) {
        RestResult restResult = new RestResult();
        restResult.success = true;
        restResult.code = 200;
        restResult.data = data;
        restResult.errorMessage = "";
        restResult.currentTime = new Date();
        return restResult;
    }

    @Override
    public String toString() {
        return "RestResult{" + "success=" + success + ", code='" + code + '\'' + ", data=" + data + ", errorMessage=" + errorMessage + ", currentTime=" + currentTime + '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }
}