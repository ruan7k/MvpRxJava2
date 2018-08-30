

package com.rambo.rxjava2.di.component;


import com.rambo.rxjava2.ui.MainActivity;
import com.rambo.rxjava2.ui.novel.NovelListActivity;
import com.rambo.rxjava2.di.module.ActivityModule;
import com.rambo.rxjava2.ui.weather.WeatherListActivity;

import dagger.Component;


@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(NovelListActivity activity);

    void inject(MainActivity activity);

    void inject(WeatherListActivity activity);


}
