package com.example.zwj.mvpdemo.mvp.live;

import com.example.zwj.mvpdemo.base.BaseView;
import com.example.zwj.mvpdemo.bean.BannerBean;
import com.example.zwj.mvpdemo.bean.GankBean;

import java.util.List;

/**
 * <b>创建时间</b> 17/6/2 <br>
 *
 * @author zhouwenjun
 */

public interface HomeFollowContact {

    interface View extends BaseView{

        void onRefreshSuccess(List<GankBean> gankBeanList);

        void onLoadMoreSuccess(List<GankBean> gankBeanList);

        void onRefreshFailed();

        void onLoadMoreFailed();

        void onLoadBannerDataSuccess(BannerBean bannerBean);
    }
}
