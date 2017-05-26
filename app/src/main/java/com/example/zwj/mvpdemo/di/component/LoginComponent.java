package com.example.zwj.mvpdemo.di.component;

import com.example.zwj.mvpdemo.di.module.LoginModule;
import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.login.LoginActivity;

import dagger.Component;

/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */

@ActivityScope
@Component(modules = LoginModule.class, dependencies = AppComponent.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
