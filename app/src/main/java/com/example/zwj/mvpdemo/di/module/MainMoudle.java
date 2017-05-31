package com.example.zwj.mvpdemo.di.module;

import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.login.LoginContact;
import com.example.zwj.mvpdemo.mvp.main.MainContact;

import dagger.Module;
import dagger.Provides;

/**
 * <b>创建时间</b> 17/5/27 <br>
 *
 * @author zhouwenjun
 */
@Module
public class MainMoudle {

    private MainContact.View view;

    public MainMoudle(MainContact.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainContact.View provideMainContactView() {
        return this.view;
    }
}
