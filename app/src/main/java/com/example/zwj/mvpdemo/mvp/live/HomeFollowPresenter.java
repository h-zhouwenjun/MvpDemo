package com.example.zwj.mvpdemo.mvp.live;

import android.content.Context;

import com.example.zwj.mvpdemo.base.BasePresenter;
import com.example.zwj.mvpdemo.bean.GankBean;
import com.example.zwj.mvpdemo.http.api.GankApi;
import com.example.zwj.mvpdemo.http.callback.OnResultCallBack;
import com.example.zwj.mvpdemo.http.subscriber.HttpSubscriber;
import com.example.zwj.mvpdemo.utils.FCLogger;

import java.util.List;

import javax.inject.Inject;

/**
 * <b>创建时间</b> 17/6/2 <br>
 *
 * @author zhouwenjun
 */

public class HomeFollowPresenter extends BasePresenter<HomeFollowContact.View>{

    @Inject
    public HomeFollowPresenter(HomeFollowContact.View rootView) {
        super(rootView);
    }

    /**
     * 加载首页数据
     */
    public void getMeiZhiData(Context context, final boolean isLoadMore, String type, int count, int page) {
        HttpSubscriber<List<GankBean>> mHttpObserver = new HttpSubscriber<>(new OnResultCallBack<List<GankBean>>() {
            @Override
            public void onSuccess(List<GankBean> gankBeanList) {
                if (gankBeanList != null && gankBeanList.size() > 0) {
                    mRootView.dismissLoading();
                    if (isLoadMore) {
                        mRootView.onLoadMoreSuccess(gankBeanList);
                    } else {
                        mRootView.onRefreshSuccess(gankBeanList);
                    }
                }
            }

            @Override
            public void onError(int code, String errorMsg) {
                FCLogger.debug(errorMsg);
                if (isLoadMore) {
                    mRootView.onLoadMoreFailed();
                } else {
                    mRootView.onRefreshFailed();
                }
            }
        });
        GankApi.getInstance(context).getGankData(mHttpObserver, type, count, page);
    }
}
