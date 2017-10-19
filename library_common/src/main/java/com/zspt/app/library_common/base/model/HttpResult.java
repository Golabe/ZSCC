package com.zspt.app.library_common.base.model;

/**
 * Created by yuequan on 2017/10/9.
 */

public class HttpResult <T> {

    private int status;
    private String message;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T result) {
        this.data = result;
    }
}
