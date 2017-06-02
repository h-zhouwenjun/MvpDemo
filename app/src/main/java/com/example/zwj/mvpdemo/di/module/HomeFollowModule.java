package com.example.zwj.mvpdemo.di.module;

import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.live.HomeFollowContact;
import com.example.zwj.mvpdemo.mvp.live.HomeSmallVideoContact;

import dagger.Module;
import dagger.Provides;

/**
 * <b>创建时间</b> 17/6/2 <br>
 *
 * @author zhouwenjun
 */
@Module
public class HomeFollowModule {

    private HomeFollowContact.View view;

    public HomeFollowModule(HomeFollowContact.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    HomeFollowContact.View provideHomeFollowContactView() {
        return this.view;
    }
}
