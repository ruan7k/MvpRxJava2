package com.rambo.rxjava2.http.exception;


import android.support.annotation.NonNull;

import com.google.gson.JsonParseException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;
import retrofit2.Response;

/**
 * 异常工厂类中，通过传入对应的Throwable错误，然后根据Throwable的不同类型，生成不同的与之对应的ApiException异常
 *
 * @author rambo
 * @version 1.0 2018-08-29
 * @since JDK 1.8
 */
public class FactoryException {

    //private static final String HttpException_MSG = "网络错误";
    private static final String RunTimeException_MSG = "运行时异常";
    private static final String ConnectException_MSG = "连接失败";
    private static final String JSONException_MSG = "gson解析失败";
    private static final String UnknownHostException_MSG = "请检查网络是否可用";

    /**
     * 解析异常
     *
     * @param e
     * @return
     */
    public static ApiException parseExcetpion(Throwable e) {
        ApiException apiException = new ApiException(e);
        if (e instanceof HttpException) {
            HttpException httpException=(HttpException)e;
            apiException= buildHttpError(apiException,httpException.response());
            apiException.setCode(CodeException.HTTP_ERROR);
        } else if (e instanceof RuntimeException) {
            apiException.setCode(CodeException.RUNTIME_ERROR);
            apiException.setDisplayMessage(RunTimeException_MSG);
        } else if (e instanceof ConnectException ||e instanceof SocketTimeoutException) {
            apiException.setCode(CodeException.NETWORD_ERROR);
            apiException.setDisplayMessage(ConnectException_MSG);
        } else if (e instanceof JsonParseException) {
            apiException.setCode(CodeException.JSON_ERROR);
            apiException.setDisplayMessage(JSONException_MSG);
        }else if (e instanceof UnknownHostException){
            apiException.setCode(CodeException.UNKOWNHOST_ERROR);
            apiException.setDisplayMessage(UnknownHostException_MSG);
        } else {
            apiException.setCode(CodeException.UNKNOWN_ERROR);
            apiException.setDisplayMessage(e.getMessage());
        }
        return apiException;
    }





    public static ApiException  buildHttpError(ApiException error,Response response) {
        switch (response.code()) {
            case 400:
                error.setDisplayMessage("请求参数有误"); // signature Attestation of failure
                break;
            case 403:
                error.setDisplayMessage("请求被拒绝");
                break;
            case 404:
                error.setDisplayMessage("资源未找到");
                break;
            case 405:
                error.setDisplayMessage("请求方式不被允许");
                break;
            case 408:
                error.setDisplayMessage("请检查网络是否可用，再行尝试");  // 请求超时
                break;
            case 422:
                error.setDisplayMessage("请求语义错误");
                break;
            case 500:
                error.setDisplayMessage("服务器逻辑错误");
                break;
            case 502:
                error.setDisplayMessage("服务器网关错误");
                break;
            case 504:
                error.setDisplayMessage("服务器网关超时");
                break;
            default:
                error.setDisplayMessage(response.message());
                break;
        }
        return error;
    }


}
