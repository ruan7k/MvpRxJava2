

package com.rambo.rxjava2.di.module;

import android.content.Context;

import com.rambo.rxjava2.R;
import com.rambo.rxjava2.base.BaseActivity;
import com.rambo.rxjava2.databinding.ActivityWeatherListBinding;
import com.rambo.rxjava2.di.ActivityContext;
import com.rambo.rxjava2.http.ApiService;
import com.rambo.rxjava2.http.RetrofitClient;
import com.rambo.rxjava2.ui.adapter.MainAdapter;
import com.rambo.rxjava2.ui.adapter.NovelAdapter;
import com.rambo.rxjava2.ui.entity.NovelBean;
import com.rambo.rxjava2.ui.novel.NovelMvpPresenter;
import com.rambo.rxjava2.ui.novel.NovelMvpView;
import com.rambo.rxjava2.ui.novel.NovelPresenter;
import com.rambo.rxjava2.ui.weather.WeatherListViewModle;

import java.sql.Array;
import java.util.Arrays;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private BaseActivity mActivity;

    public ActivityModule(BaseActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    BaseActivity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    NovelAdapter provideNovelAdapter() {
        return new NovelAdapter(R.layout.novel_list_item);
    }

    @Provides
    MainAdapter provideMainAdapter() {
        return new MainAdapter(Arrays.asList(mActivity.getResources().getStringArray(R.array.title_list)));
    }



    @Provides
    ApiService provideApiService() {
        return RetrofitClient.create(ApiService.class);
    }

    @Provides
    NovelMvpPresenter<NovelMvpView> provideNovelMvpPresenter(NovelPresenter<NovelMvpView> presenter) {
        return presenter;
    }


//    @Provides
//    WeatherListViewModle provideWeatherListViewModle(ApiService apiService,BaseActivity mActivity) {
//        return new WeatherListViewModle(mActivity,apiService);
//    }




}
