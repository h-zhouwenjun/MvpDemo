package com.example.zwj.mvpdemo.app;

import android.app.Application;
import android.content.Context;

import com.example.zwj.mvpdemo.di.component.AppComponent;
import com.example.zwj.mvpdemo.di.component.DaggerAppComponent;
import com.example.zwj.mvpdemo.di.module.AppModule;
import com.example.zwj.mvpdemo.utils.Utils;

/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */

public class DemoApplication extends Application{

    private static Context context;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        Utils.init(getApplicationContext());
        context = getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    public static Context getContext() {
        return context;
    }
}
