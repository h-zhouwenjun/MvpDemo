package com.example.zwj.mvpdemo.mvp.main;

import android.content.Context;

import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.base.BaseActivity;
import com.example.zwj.mvpdemo.di.component.AppComponent;
import com.example.zwj.mvpdemo.di.component.DaggerMainComponent;
import com.example.zwj.mvpdemo.di.module.MainMoudle;

/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContact.View{

    @Override
    protected void ComponentInject(AppComponent appComponent) {
        DaggerMainComponent
                .builder()
                .appComponent(appComponent)
                .mainMoudle(new MainMoudle(this)) //请将MainModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mPresenter.initTabLayout(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void showMsg(int msgId) {

    }

    @Override
    public Context getContext() {
        return mContext;
    }

}
