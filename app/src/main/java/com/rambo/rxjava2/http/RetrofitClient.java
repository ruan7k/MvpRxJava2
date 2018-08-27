package com.rambo.rxjava2.http;


import com.rambo.rxjava2.BuildConfig;
import com.rambo.rxjava2.base.URLConstant;
import com.rambo.rxjava2.http.chain.TokenInterceptor;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

    private static volatile Retrofit mRetrofit;

    public static <T> T create(Class<T> clazz) {
        if (mRetrofit == null) {
            synchronized (RetrofitClient.class) {
                if (mRetrofit == null) {
                    mRetrofit = new Retrofit.Builder()
                            .baseUrl(URLConstant.BASE_URL)
                            .client(getOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return mRetrofit.create(clazz);
    }


    public static Retrofit getInstance() {
        if (mRetrofit == null) {
            synchronized (RetrofitClient.class) {
                if (mRetrofit == null) {

                    mRetrofit = new Retrofit.Builder()
                            .baseUrl(URLConstant.BASE_URL)
                            .client(getOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();

                }
            }
        }
        return mRetrofit;
    }


    //获取okhttp客户端
    private static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor mLoggingInterceptor = createHttpLoggingInterceptor();
        TokenInterceptor mTokenInterceptor = new TokenInterceptor();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(mLoggingInterceptor)
                .retryOnConnectionFailure(Boolean.FALSE)            // 失败时重新连接
                .connectTimeout(10, TimeUnit.SECONDS)               // 超时时间
                .addNetworkInterceptor(mTokenInterceptor)           // token interceptor
                // 信任自有主机名
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {

                        return true;
                    }
                })
                .build();

        return client;
    }


    private static HttpLoggingInterceptor createHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return loggingInterceptor;
    }


}


