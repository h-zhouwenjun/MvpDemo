package com.example.zwj.mvpdemo.di.component;

import com.example.zwj.mvpdemo.di.module.HomeFollowModule;
import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.live.HomeFollowFragment;

import dagger.Component;

/**
 * <b>创建时间</b> 17/6/2 <br>
 *
 * @author zhouwenjun
 */
@ActivityScope
@Component(modules = HomeFollowModule.class, dependencies = AppComponent.class)
public interface HomeFollowComponent {
    void inject(HomeFollowFragment homeSmallVideoFragment);
}
