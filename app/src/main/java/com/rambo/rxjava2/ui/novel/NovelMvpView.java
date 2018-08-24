package com.rambo.rxjava2.ui.novel;

import com.rambo.rxjava2.mvp.BaseView;
import com.rambo.rxjava2.ui.entity.NovelBean;

import java.util.List;


public interface NovelMvpView extends BaseView{

    void loadDataSucceed(List<NovelBean> list);

}
