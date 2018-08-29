package com.rambo.rxjava2.http.exception;

/**
 * 异常类封装
 *
 * @author rambo
 * @version 1.0 2018-08-29
 * @since JDK 1.8
 */
public class ApiException  extends Exception{

    //错误码
    private int code;
    //错误详情
    private String displayMessage;

    public ApiException(Throwable e) {
        super(e);
    }

    @CodeException.CodeEp
    public int getCode() {
        return code;
    }

    public void setCode(@CodeException.CodeEp int code) {
        this.code = code;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

}
