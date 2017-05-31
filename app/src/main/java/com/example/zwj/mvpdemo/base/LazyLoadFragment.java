package com.example.zwj.mvpdemo.base;

import android.view.View;

/**
 * <b>创建时间</b> 17/5/27 <br>
 *
 * @author zhouwenjun
 */

public abstract class LazyLoadFragment<P extends BasePresenter> extends BaseFragment<P> {

    public boolean isInit = false;//视图是否已经初始化
    public boolean isLoad = false;//视图是否已经加载过

    @Override
    protected void initView(View rootView) {
        isInit = true;
        isCanLoadData();
    }

    /**
     * 判断是否可以加载数据，如果可以便进行数据的加载
     */
    private void isCanLoadData() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            lazyLoad();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }


    /**
     * 当视图初始化并且对可见时加载数据
     */
    public abstract void lazyLoad();


    /**
     * 当该视图对用户不可见并且已经加载过数据的时候，如果需要在切换到其他页面时停止加载数据，通过覆写此方法实现
     */
    public void stopLoad() {
    }


    /**
     * 说明：当前视图可见性发生变化时调用该方法
     *
     * @param isVisibleToUser 当前视图是否可见
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }


    /**
     * 视图销毁时将Fragment是否初始化的状态变为false
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
    }
}
