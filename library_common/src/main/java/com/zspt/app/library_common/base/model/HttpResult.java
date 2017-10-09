package com.zspt.app.library_common.base.model;

/**
 * Created by yuequan on 2017/10/9.
 */

public class HttpResult <T> {
    private boolean error;
    private int code;
    private String message;

    private T result;


    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
