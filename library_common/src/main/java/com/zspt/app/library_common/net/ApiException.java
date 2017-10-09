package com.zspt.app.library_common.net;

/**
 * Created by yuequan on 2017/10/9.
 */

public class ApiException extends RuntimeException {

    private static final int CODE1 = 1000;
    private static final int CODE2 = 1001;
    private static final int CODE3 = 1002;

    public ApiException() {
        super("服务器繁忙");
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(int code) {
        super();
    }

    private static String getApiExceptionMessage(int code) {

        String message = null;

        switch (code) {
            case CODE1:
                message="用户不存在";
                break;
            case CODE2:
                message="服务器繁忙";
                break;
            case CODE3:
                message="请先登陆";
                break;
            default:
                message="未知错误";
                break;
        }
        return message;

    }
}
