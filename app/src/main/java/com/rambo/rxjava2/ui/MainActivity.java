package com.rambo.rxjava2.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rambo.rxjava2.R;
import com.rambo.rxjava2.base.BaseActivity;
import com.rambo.rxjava2.ui.adapter.MainAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * file explain
 *
 * @author rambo
 * @version 1.0 2018-08-24
 * @since JDK 1.8
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));
        getDaggerActivityComponent().inject(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        ARouter.getInstance().build("/rambo/novellist").navigation();
                        break;
                    case 1:
                        ARouter.getInstance().build("/rambo/weatherlist").navigation();
                        break;
                }
            }
        });
        recyclerView.setAdapter(mainAdapter);

    }
}
