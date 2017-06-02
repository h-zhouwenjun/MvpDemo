package com.example.zwj.mvpdemo.di.module;

import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.live.HomeSmallVideoContact;

import dagger.Module;
import dagger.Provides;

/**
 * <b>创建时间</b> 17/6/1 <br>
 *
 * @author zhouwenjun
 */
@Module
public class HomeSmallVideoModule {

    private HomeSmallVideoContact.View view;

    public HomeSmallVideoModule(HomeSmallVideoContact.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    HomeSmallVideoContact.View provideHomeSmallViewContactView() {
        return this.view;
    }
}
