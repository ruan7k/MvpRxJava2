

package com.rambo.rxjava2.di.component;

import android.app.Application;
import android.content.Context;

import com.rambo.rxjava2.base.BaseApp;
import com.rambo.rxjava2.di.ApplicationContext;
import com.rambo.rxjava2.di.module.ApplicationModule;



import dagger.Component;



@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {


    @ApplicationContext
    Context context();

    BaseApp application();

    void inject(BaseApp app);




}