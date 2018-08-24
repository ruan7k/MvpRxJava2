package com.rambo.rxjava2.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.rambo.rxjava2.BuildConfig;
import com.rambo.rxjava2.di.component.ApplicationComponent;
import com.rambo.rxjava2.di.component.DaggerApplicationComponent;
import com.rambo.rxjava2.di.module.ApplicationModule;

import timber.log.Timber;

/**
 * file explain
 *
 * @author rambo
 * @version 1.0 2018-08-23
 * @since JDK 1.8
 */
public class BaseApp extends Application {

    public ApplicationComponent getDaggerApplicationComponent() {
        return daggerApplicationComponent;
    }

    ApplicationComponent daggerApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        daggerApplicationComponent=DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this)).build();
        daggerApplicationComponent.inject(this);

        initAroute();
        initTimber();
    }

    private void initAroute(){
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }


    private void initTimber(){
        Timber.plant(new Timber.DebugTree());
        if (BuildConfig.DEBUG) {

        } else {
            //Timber.plant(new CrashReportingTree());
        }
    }
}
