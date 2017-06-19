package com.example.zwj.mvpdemo.di.module;

import com.example.zwj.mvpdemo.di.scop.ActivityScope;
import com.example.zwj.mvpdemo.mvp.dynamic.DynamicContact;

import dagger.Module;
import dagger.Provides;

/**
 * <b>创建时间</b> 17/6/16 <br>
 *
 * @author zhouwenjun
 */
@Module
public class DynamicModule {

    private DynamicContact.View view;

    public DynamicModule(DynamicContact.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    DynamicContact.View provideDynamicContactView() {
        return this.view;
    }
}
