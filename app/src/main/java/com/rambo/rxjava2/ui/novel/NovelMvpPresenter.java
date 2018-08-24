package com.rambo.rxjava2.ui.novel;

import com.rambo.rxjava2.mvp.BasePresenter;
import com.rambo.rxjava2.ui.entity.NovelBean;

import java.util.List;

/**
 * file explain
 *
 * @author rambo
 * @version 1.0 2018-08-23
 * @since JDK 1.8
 */
public interface NovelMvpPresenter<V extends NovelMvpView> extends BasePresenter<V> {

    void requestData();

}
