package com.rambo.rxjava2.base;

import android.app.Activity;
import android.os.Bundle;

import com.rambo.rxjava2.di.component.ActivityComponent;
import com.rambo.rxjava2.di.component.DaggerActivityComponent;
import com.rambo.rxjava2.di.module.ActivityModule;

import butterknife.Unbinder;

/**
 * file explain
 *
 * @author rambo
 * @version 1.0 2018-08-23
 * @since JDK 1.8
 */
public  abstract  class BaseActivity extends Activity {

    ActivityComponent daggerActivityComponent;
    private Unbinder mUnBinder;

    public ActivityComponent getDaggerActivityComponent() {
        return daggerActivityComponent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        daggerActivityComponent=DaggerActivityComponent.builder()
                                .activityModule(new ActivityModule(this))
                .applicationComponent(((BaseApp) getApplication()).getDaggerApplicationComponent())
                .build();

    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }
}
