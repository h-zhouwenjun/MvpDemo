package com.example.zwj.mvpdemo.di.module;

import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.live.HomeContact;

import dagger.Module;
import dagger.Provides;

/**
 * <b>创建时间</b> 17/5/31 <br>
 *
 * @author zhouwenjun
 */
@Module
public class HomeModule {

    private HomeContact.View view;

    public HomeModule(HomeContact.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    HomeContact.View provideHomeContactView() {
        return this.view;
    }
}
