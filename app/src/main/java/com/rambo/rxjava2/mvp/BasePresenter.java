package com.rambo.rxjava2.mvp;

/**
 * file explain
 *
 * @author rambo
 * @version 1.0 2018-08-20
 * @since JDK 1.8
 */
public interface BasePresenter<V extends BaseView> {


    void attachView(V view);

    void detachView();

}
