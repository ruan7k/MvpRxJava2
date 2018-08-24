package com.rambo.rxjava2.ui.novel;

import com.rambo.rxjava2.http.ApiService;
import com.rambo.rxjava2.http.BaseDataResult;
import com.rambo.rxjava2.http.DefaultObserver;
import com.rambo.rxjava2.mvp.BaseMvpPresenter;
import com.rambo.rxjava2.ui.entity.NovelBean;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * file explain
 *
 * @author rambo
 * @version 1.0 2018-08-23
 * @since JDK 1.8
 */
public class NovelPresenter<V extends NovelMvpView> extends BaseMvpPresenter<V>
        implements NovelMvpPresenter<V>{

    @Inject
    public NovelPresenter(ApiService api) {
        super(api);
    }

    @Override
    public void requestData() {
        getBaseView().showLoading();
        getApiService().getNovelList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn( Schedulers.io())
                .subscribe(new DefaultObserver<BaseDataResult<List<NovelBean>>>(this) {
                    @Override
                    public void onSuccess(BaseDataResult<List<NovelBean>> response) {
                        getBaseView().hideLoading();
                        List<NovelBean>  list=  response.getData();
                        getBaseView().loadDataSucceed(list);

                    }

                    @Override
                    public void onFail(BaseDataResult<List<NovelBean>> response, String message) {
                        getBaseView().hideLoading();
                        getBaseView().showFaild(message);
                    }
                });
    }
}
