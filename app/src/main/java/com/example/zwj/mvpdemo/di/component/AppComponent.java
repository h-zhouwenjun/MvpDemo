package com.example.zwj.mvpdemo.di.component;

import android.app.Application;

import com.example.zwj.mvpdemo.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Application Application();
}
