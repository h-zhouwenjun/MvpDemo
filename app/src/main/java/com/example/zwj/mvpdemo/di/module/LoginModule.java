package com.example.zwj.mvpdemo.di.module;

import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.login.LoginContact;

import dagger.Module;
import dagger.Provides;

/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */
@Module
public class LoginModule {

    private LoginContact.View view;

    public LoginModule(LoginContact.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    LoginContact.View provideTempLateView() {
        return this.view;
    }
}
