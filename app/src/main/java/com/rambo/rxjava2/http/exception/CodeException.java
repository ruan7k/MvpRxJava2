package com.rambo.rxjava2.http.exception;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 异常code定义
 *
 * @author rambo
 * @version 1.0 2018-08-29
 * @since JDK 1.8
 */
public class CodeException {

    //网络错误
    public static final int NETWORD_ERROR = 0x1;
    //http错误
    public static final int HTTP_ERROR = 0x2;
    //gson错误
    public static final int JSON_ERROR = 0x3;
    //未知错误
    public static final int UNKNOWN_ERROR = 0x4;
    //运行时异常-包含自定义异常
    public static final int RUNTIME_ERROR = 0x5;
    //无法解析该域名
    public static final int UNKOWNHOST_ERROR = 0x6;


    @IntDef({NETWORD_ERROR, HTTP_ERROR, RUNTIME_ERROR, UNKNOWN_ERROR, JSON_ERROR, UNKOWNHOST_ERROR})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CodeEp {
    }

}
