

package com.rambo.rxjava2.di.module;

import android.app.Application;
import android.content.Context;


import com.rambo.rxjava2.base.BaseApp;
import com.rambo.rxjava2.di.ApplicationContext;



import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    private final BaseApp mApplication;

    public ApplicationModule(BaseApp application) {
        mApplication = application;
    }

    @Provides
    BaseApp provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }


}
