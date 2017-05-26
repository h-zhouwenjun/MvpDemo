package com.example.zwj.mvpdemo.mvp.view.Iview;

import android.content.Context;

/**
 * <b>创建时间</b> 17/5/25 <br>
 *
 * @author zhouwenjun
 */

public interface BaseView {

    /**
     * 数据加载或耗时加载时界面显示
     */
    void showLoading();

    /**
     * 数据加载或耗时加载完成时界面显示
     */
    void dismissLoading();

    /**
     * 消息提示，如 Toast，Dialog等
     */
    void showMsg(String msg);

    void showMsg(int msgId);

    /**
     * 获取Context
     *
     * @return
     */
    Context getContext();

}
