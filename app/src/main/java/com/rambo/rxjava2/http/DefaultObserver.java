package com.rambo.rxjava2.http;

import com.rambo.rxjava2.mvp.BaseMvpPresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * file explain
 *
 * @author rambo
 * @version 1.0 2018-08-23
 * @since JDK 1.8
 */
public abstract class DefaultObserver<T extends BaseDataResult> implements Observer<T> {


    BaseMvpPresenter presenter;

    public DefaultObserver(BaseMvpPresenter p){
        presenter=p;
    }


    public abstract void onSuccess(T response);

    public abstract void onFail(T response, String message);


    @Override
    public void onSubscribe(Disposable d) {
        presenter.getDisposableList().add(d);
    }

    @Override
    public void onNext(T t) {
        if(t.getCode()==200){
            onSuccess(t);
        }else{
            onFail(t,t.getMsg());
        }

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
