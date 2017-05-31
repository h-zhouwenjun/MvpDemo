package com.example.zwj.mvpdemo.mvp.friend;

import android.content.Context;

import com.example.zwj.mvpdemo.base.BasePresenter;
import com.example.zwj.mvpdemo.bean.GankBean;
import com.example.zwj.mvpdemo.http.api.ApiResponse;
import com.example.zwj.mvpdemo.http.api.GankApi;
import com.example.zwj.mvpdemo.http.callback.OnResultCallBack;
import com.example.zwj.mvpdemo.http.subscriber.HttpSubscriber;
import com.example.zwj.mvpdemo.utils.FCLogger;

import java.util.List;

import javax.inject.Inject;

/**
 * <b>创建时间</b> 17/5/31 <br>
 *
 * @author zhouwenjun
 */

public class HomePresenter extends BasePresenter<HomeContact.View> {

    private HttpSubscriber<List<GankBean>> mHttpObserver;

    @Inject
    public HomePresenter(HomeContact.View rootView) {
        super(rootView);
    }

    /**
     * 加载首页数据
     */
    public void getMeiZhiData(Context context, String type, int count, int page) {
        mHttpObserver = new HttpSubscriber<>(new OnResultCallBack<List<GankBean>>() {
            @Override
            public void onSuccess(List<GankBean> gankBeanList) {
                if (gankBeanList != null && gankBeanList.size() >0){
                    mRootView.dismissLoading();
                }
            }

            @Override
            public void onError(int code, String errorMsg) {
                FCLogger.debug(errorMsg);
            }
        });
        GankApi.getInstance(context).getGankData(mHttpObserver, type, count, page);
    }
}
