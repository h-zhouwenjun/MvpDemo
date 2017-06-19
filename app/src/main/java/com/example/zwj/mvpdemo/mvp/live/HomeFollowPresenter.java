package com.example.zwj.mvpdemo.mvp.live;

import android.content.Context;

import com.example.zwj.mvpdemo.base.BasePresenter;
import com.example.zwj.mvpdemo.bean.BannerBean;
import com.example.zwj.mvpdemo.bean.GankBean;
import com.example.zwj.mvpdemo.http.api.GankApi;
import com.example.zwj.mvpdemo.http.callback.OnResultCallBack;
import com.example.zwj.mvpdemo.http.subscriber.HttpSubscriber;
import com.example.zwj.mvpdemo.utils.FCLogger;

import java.util.ArrayList;
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

    public void loadBannerData(){
        BannerBean bannerBean = new BannerBean();
        List<String> imgs = new ArrayList<>();
        imgs.add("https://ws1.sinaimg.cn/mw690/610dc034ly1ffwb7npldpj20u00u076z.jpg");
        imgs.add("https://ws1.sinaimg.cn/large/610dc034ly1ffxjlvinj5j20u011igri.jpg");
        imgs.add("https://ws1.sinaimg.cn/large/610dc034ly1ffyp4g2vwxj20u00tu77b.jpg");
        List<String> tips = new ArrayList<>();
        tips.add("daimajia");
        tips.add("daimajia");
        tips.add("daimajia");
        bannerBean.imgs = imgs;
        bannerBean.tips = tips;
        mRootView.onLoadBannerDataSuccess(bannerBean);
    }
}
