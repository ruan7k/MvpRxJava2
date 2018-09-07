package com.rambo.rxjava2.ui.weather;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.Toast;

import com.rambo.rxjava2.BR;
import com.rambo.rxjava2.databinding.ActivityWeatherListBinding;
import com.rambo.rxjava2.di.ActivityContext;
import com.rambo.rxjava2.http.ApiService;
import com.rambo.rxjava2.http.BaseDataResult;
import com.rambo.rxjava2.ui.entity.WeatherBean;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * WeatherListViewModle
 *
 * @author rambo
 * @version 1.0 2018-08-29
 * @since JDK 1.8
 */
public class WeatherListViewModle {

    Context activityContext;

    ApiService service;

    public WeatherBean weatherBean;

    ViewDataBinding binding;


    public WeatherListViewModle(Context context, ApiService api,ViewDataBinding viewDataBinding) {
        this.activityContext = context;
        this.service = api;
        this.binding=viewDataBinding;
    }

    public void requestData() {
        service.getWeatherList("武汉")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseDataResult<WeatherBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseDataResult<WeatherBean> listBaseDataResult) {
                        weatherBean = listBaseDataResult.getData();

                        binding.setVariable(BR.viewModel,this);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void buttonClick(View view) {
        Toast.makeText(activityContext, "你点了我一下", Toast.LENGTH_SHORT).show();
    }


}
