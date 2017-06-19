package com.example.zwj.mvpdemo.di.component;

import com.example.zwj.mvpdemo.di.module.DynamicModule;
import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.dynamic.DynamicFragment;

import dagger.Component;

/**
 * <b>创建时间</b> 17/6/16 <br>
 *
 * @author zhouwenjun
 */
@ActivityScope
@Component(modules = DynamicModule.class, dependencies = AppComponent.class)
public interface DynamicComponent {
    void inject(DynamicFragment dynamicFragment);
}
