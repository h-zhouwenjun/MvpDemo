package com.example.zwj.mvpdemo.mvp.presenter.IPresenter;

/**
 * <b>创建时间</b> 17/5/25 <br>
 *
 * @author zhouwenjun
 */

public interface BasePresenter {

    /**
     * presenter 开始处理方法
     */
    void start();

    /**
     * 处理一些销毁工作，在界面结束时候调用
     */
    void finish();

}
