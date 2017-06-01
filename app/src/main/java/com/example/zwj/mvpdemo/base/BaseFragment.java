package com.example.zwj.mvpdemo.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zwj.mvpdemo.app.DemoApplication;
import com.example.zwj.mvpdemo.di.component.AppComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * <b>创建时间</b> 17/5/25 <br>
 *
 * @author zhouwenjun
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    /**
     * 图片加载
     */
    protected BaseActivity mContext;
    protected View mRootView;
    protected Intent mBundleIntent;
    @Inject
    protected P mPresenter;
    protected DemoApplication demoApplication;
    protected boolean mIsPrepared = false;
    protected boolean mIsFirstResume = true;
    protected boolean mIsFirstVisible = true;
    protected boolean mIsFirstInvisible = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = (BaseActivity) getActivity();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getLayoutId() != 0) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, mRootView);
        }
        demoApplication = (DemoApplication) mContext.getApplication();
        ComponentInject(demoApplication.getAppComponent());//依赖注入
        initView(mRootView);
        setUserVisibleHint(true);
        setListener();
        initData();

        return mRootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (hidden) {
            mBundleIntent = null;
        }
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mIsFirstResume) {
            mIsFirstResume = false;
            return;
        }
        if (getUserVisibleHint()) {
            onUserVisible();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            if (mIsFirstVisible) {
                mIsFirstVisible = false;
                initPrepare();
            } else {
                onUserVisible();
            }
        } else {
            if (mIsFirstInvisible) {
                mIsFirstInvisible = false;
                onFirstUserInvisible();
            } else {
                onUserInvisible();
            }
        }
    }

    public synchronized void initPrepare() {
        if (mIsPrepared) {
            onFirstUserVisible();
        } else {
            mIsPrepared = true;
        }
    }

    /**
     * 第一次对用户可见时会调用该方法
     */
    protected void onFirstUserVisible() {
    }

    ;

    /**
     * 对用户可见时会调用该方法，除了第一次
     */
    public void onUserVisible() {
    }

    /**
     * 第一次对用户不可见时会调用该方法
     */
    public void onFirstUserInvisible() {
    }

    /**
     * 对用户不可见时会调用该方法，除了第一次
     */
    public void onUserInvisible() {
    }


    @Override
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            onUserInvisible();
        }
    }

    /**
     * 重写ActionBar
     *
     * @param activity
     */
    public void initActionBar(Activity activity) {
    }

    public void setBundleIntent(Intent bundleIntent) {
        mBundleIntent = bundleIntent;
    }

    public <T extends View> T obtainView(int resId) {
        return (T) mRootView.findViewById(resId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * 返回操作
     */
    public void onBackPressed() {
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 设置监听
     */
    protected abstract void setListener();

    /**
     * 初始化界面
     *
     * @param rootView
     */
    protected abstract void initView(View rootView);

    /**
     * 获取布局
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 依赖注入的入口
     */
    protected abstract void ComponentInject(AppComponent appComponent);

}

