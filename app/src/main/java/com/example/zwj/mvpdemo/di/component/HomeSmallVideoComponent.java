package com.example.zwj.mvpdemo.di.component;

import com.example.zwj.mvpdemo.di.module.HomeSmallVideoModule;
import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.live.HomeSmallVideoFragment;

import dagger.Component;

/**
 * <b>创建时间</b> 17/6/1 <br>
 *
 * @author zhouwenjun
 */
@ActivityScope
@Component(modules = HomeSmallVideoModule.class, dependencies = AppComponent.class)
public interface HomeSmallVideoComponent {
    void inject(HomeSmallVideoFragment homeSmallVideoFragment);
}
