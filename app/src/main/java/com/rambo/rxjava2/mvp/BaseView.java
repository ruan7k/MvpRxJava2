package com.rambo.rxjava2.mvp;


public interface BaseView {

    // 显示进度中
    void showLoading();

    // 隐藏进度
    void hideLoading();

    // 显示请求失败
    void showFaild(String message);
}
