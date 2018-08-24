package com.rambo.rxjava2.ui.novel;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rambo.rxjava2.R;
import com.rambo.rxjava2.base.BaseActivity;
import com.rambo.rxjava2.di.ActivityContext;
import com.rambo.rxjava2.ui.adapter.NovelAdapter;
import com.rambo.rxjava2.ui.entity.NovelBean;

import java.util.List;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/rambo/novellist")
public class NovelListActivity extends BaseActivity implements NovelMvpView{

    @Inject
    NovelAdapter novelAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    @ActivityContext
    Context context;

    @Inject
    NovelMvpPresenter<NovelMvpView> presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_list);
        setUnBinder(ButterKnife.bind(this));
        getDaggerActivityComponent().inject(this);
        initData();
    }

    //初始化数据
    private void initData(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        novelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        recyclerView.setAdapter(novelAdapter);
        presenter.attachView(this);
        presenter.requestData();
    }




    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showFaild(String message) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadDataSucceed(List<NovelBean> list) {
        novelAdapter.setNewData(list);
    }


    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
