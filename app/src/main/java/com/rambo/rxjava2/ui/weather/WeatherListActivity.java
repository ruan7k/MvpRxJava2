package com.rambo.rxjava2.ui.weather;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.rambo.rxjava2.BR;
import com.rambo.rxjava2.R;
import com.rambo.rxjava2.base.BaseActivity;
import com.rambo.rxjava2.databinding.ActivityWeatherListBinding;
import com.rambo.rxjava2.http.ApiService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 天气页面   mvvm 模式
 *
 * @author rambo
 * @version 1.0 2018-08-29
 * @since JDK 1.8
 */
@Route(path = "/rambo/weatherlist")
public class WeatherListActivity extends BaseActivity {

    @BindView(R.id.weather_city)
    TextView weatherCity;

    ActivityWeatherListBinding viewDataBinding;

    @Inject
    WeatherListViewModle viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDaggerActivityComponent().inject(this);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather_list);
        setUnBinder(ButterKnife.bind(this));
        viewDataBinding.setVariable(BR.viewModel, viewModel);
        viewModel.requestData();
    }


}
