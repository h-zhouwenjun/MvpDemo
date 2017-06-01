package com.example.zwj.mvpdemo.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Toast;

import com.example.zwj.mvpdemo.app.DemoApplication;
import com.example.zwj.mvpdemo.di.component.AppComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * <b>创建时间</b> 17/5/25 <br>
 *
 * @author zhouwenjun
 */

public abstract class BaseActivity<P extends BasePresenter> extends FragmentActivity{

    protected Context mContext;
    protected Handler mHandler = new Handler();
    @Inject
    protected P mPresenter;
    protected DemoApplication demoApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setBeforeLayout();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mContext = this;
        if (getLayoutId() != 0){
            setContentView(getLayoutId());
        }
        ButterKnife.bind(this);
        demoApplication = (DemoApplication) getApplication();
        ComponentInject(demoApplication.getAppComponent());//依赖注入
        initView();
        initData();
        setListener();
    }

    /**
     * 依赖注入的入口
     */
    protected abstract void ComponentInject(AppComponent appComponent);

    /**
     * 设置监听
     */
    protected abstract void setListener();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 返回当前布局文件
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 设置布局
     */
    protected void setBeforeLayout(){}

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 获取资源id
     * @param resId
     * @param <T>
     * @return
     */
    public <T extends View> T obtainView(int resId){
        return (T)findViewById(resId);
    }

    protected void invoke(Context context,Class clz){
        startActivity(new Intent(context,clz));
    }

    /**
     * 以无参数的模式启动Activity。
     *
     * @param activityClass
     */
    public void startActivity(Class<? extends Activity> activityClass) {
        startActivity(getLocalIntent(activityClass, null));
        //   me.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    /**
     * 以绑定参数的模式启动Activity。
     *
     * @param activityClass
     */
    public void startActivity(Class<? extends Activity> activityClass,
                              Bundle bd) {
        startActivity(getLocalIntent(activityClass, bd));
        //    me.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    /**
     * 获取当前程序中的本地目标
     *
     * @param localIntent
     * @return
     */
    public Intent getLocalIntent(Class<? extends Context> localIntent,
                                 Bundle bd) {
        Intent intent = new Intent(this, localIntent);
        if (null != bd) {
            intent.putExtras(bd);
        }
        return intent;
    }


}


