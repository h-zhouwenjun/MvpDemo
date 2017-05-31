package com.example.zwj.mvpdemo.di.component;

import com.example.zwj.mvpdemo.di.module.MainMoudle;
import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.main.MainActivity;

import dagger.Component;

/**
 * <b>创建时间</b> 17/5/27 <br>
 *
 * @author zhouwenjun
 */

@ActivityScope
@Component(modules = MainMoudle.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
