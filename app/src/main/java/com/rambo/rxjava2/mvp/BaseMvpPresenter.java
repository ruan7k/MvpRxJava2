package com.rambo.rxjava2.mvp;


import com.rambo.rxjava2.http.ApiService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import timber.log.Timber;


public class BaseMvpPresenter<V extends BaseView> implements BasePresenter<V> {


    String TAG = this.getClass().getSimpleName();

    ApiService apiService;

    List<Disposable> disposableList;

    public ApiService getApiService() {
        return apiService;
    }

    public List<Disposable> getDisposableList() {
        return disposableList;
    }


    @Inject
    public BaseMvpPresenter(ApiService api) {
        apiService = api;
        disposableList = new ArrayList<>();
    }

    public V getBaseView() {
        return baseView;
    }

    protected V baseView;

    @Override
    public void attachView(V view) {
        this.baseView = view;
    }


    private void removeDisposable() {
        for (int i = 0; i < disposableList.size(); i++) {
            disposableList.get(i).dispose();
            Timber.d(TAG, "Disposable:" + disposableList.get(i).isDisposed());
        }
    }

    @Override
    public void detachView() {
        removeDisposable();
        if (baseView != null) {
            baseView = null;
        }
    }
}