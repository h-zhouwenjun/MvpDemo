package com.example.zwj.mvpdemo.di.component;

import com.example.zwj.mvpdemo.di.module.HomeModule;
import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.friend.HomeFragment;

import dagger.Component;

/**
 * <b>创建时间</b> 17/5/31 <br>
 *
 * @author zhouwenjun
 */
@ActivityScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(HomeFragment fragment);
}
