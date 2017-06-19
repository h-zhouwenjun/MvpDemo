package com.example.zwj.mvpdemo.mvp.live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.adapter.TypePageAdapter;
import com.example.zwj.mvpdemo.base.BaseActivity;
import com.example.zwj.mvpdemo.base.BaseFragment;
import com.example.zwj.mvpdemo.base.BasePresenter;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * <b>创建时间</b> 17/5/31 <br>
 *
 * @author zhouwenjun
 */

public class HomePresenter extends BasePresenter<HomeContact.View> {

    private SlidingTabLayout mSlHome;
    private ViewPager mVpHome;
    private ArrayList<BaseFragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "小视频", "关注", "热门"
    };

    @Inject
    public HomePresenter(HomeContact.View rootView) {
        super(rootView);
    }

    /**
     * 初始化tabLayout
     *
     * @param context
     */
    public void initSlidingTab(View rootView, BaseActivity context) {
        mFragments.add(HomeSmallVideoFragment.newInstance("", ""));
        mFragments.add(HomeFollowFragment.newInstance("", ""));
        mFragments.add(HomeFollowFragment.newInstance("", ""));
        mSlHome = (SlidingTabLayout) rootView.findViewById(R.id.tl_home);
        mVpHome = (ViewPager) rootView.findViewById(R.id.vp_home);
//        mSlHome.setTabMode(TabLayout.MODE_FIXED);
        TypePageAdapter mAdapter = new TypePageAdapter(context.getSupportFragmentManager());
        mAdapter.setData(mFragments, mTitles);
        mVpHome.setOffscreenPageLimit(2);
        mVpHome.setAdapter(mAdapter);
        mSlHome.setViewPager(mVpHome);
    }

}
