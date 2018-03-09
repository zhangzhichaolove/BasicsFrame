package com.peak.chao.basicsframe.net;

/**
 * Created by Chao  2018/3/9 on 11:47
 * description 自定义网络异常
 */

public class ApiException extends RuntimeException {
    private int code;

    public ApiException(int code, Throwable cause) {
        super("ApiException:", cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
