package com.example.zwj.mvpdemo.mvp.splash;

import android.Manifest;
import android.os.Bundle;

import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.base.BaseActivity;
import com.example.zwj.mvpdemo.di.component.AppComponent;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SplashActivity extends BaseActivity {

    @Override
    protected void ComponentInject(AppComponent appComponent) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.requestEach(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION).subscribe(new Observer<Permission>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Permission permission) {
                if (permission.granted){

                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}
