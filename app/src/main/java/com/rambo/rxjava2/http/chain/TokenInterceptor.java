package com.rambo.rxjava2.http.chain;

import android.text.TextUtils;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class TokenInterceptor implements Interceptor {

    public String TOKEN_KEY = "token";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (TextUtils.isEmpty("") || alreadyHasAuthorizationHeader(originalRequest)) {
            return chain.proceed(originalRequest);
        }
        Request authorised = originalRequest.newBuilder()
                .header(TOKEN_KEY, "ceshi")                       // Authorization Token
                .build();

        return chain.proceed(authorised);

    }

    private boolean alreadyHasAuthorizationHeader(Request request) {
        if (request != null) {
            if (request.headers() != null && request.header(TOKEN_KEY) != null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }





}
