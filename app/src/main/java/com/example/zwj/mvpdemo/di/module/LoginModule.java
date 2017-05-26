package com.example.zwj.mvpdemo.di.module;

import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.login.LoginCantact;

import dagger.Module;
import dagger.Provides;

/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */
@Module
public class LoginModule {

    private LoginCantact.View view;

    public LoginModule(LoginCantact.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    LoginCantact.View provideTempLateView() {
        return this.view;
    }
}
