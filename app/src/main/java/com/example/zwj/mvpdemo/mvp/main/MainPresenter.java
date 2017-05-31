package com.example.zwj.mvpdemo.mvp.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.base.BaseActivity;
import com.example.zwj.mvpdemo.base.BasePresenter;
import com.example.zwj.mvpdemo.bean.TabBean;
import com.example.zwj.mvpdemo.mvp.friend.HomeFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */

public class MainPresenter extends BasePresenter<MainContact.View> {

    private CommonTabLayout mTlMain;
    private ViewPager mVpMain;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String[] mTitles = {"首页", "消息", "联系人"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private int[] mIconSelectIds = {
            R.drawable.tab_home_select, R.drawable.tab_speech_select, R.drawable.tab_contact_select};
    private int[] mIconUnselectIds = {
            R.drawable.tab_home_unselect, R.drawable.tab_speech_unselect, R.drawable.tab_contact_unselect};

    @Inject
    public MainPresenter(MainContact.View rootView) {
        super(rootView);
    }

    /**
     * 初始化tab
     *
     * @param context
     */
    public void initTabLayout(BaseActivity context) {
        for (String title : mTitles) {
            mFragments.add(HomeFragment.newInstance(title, ""));
        }

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabBean(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mTlMain = (CommonTabLayout) context.obtainView(R.id.tl_main);
        mVpMain = (ViewPager) context.obtainView(R.id.vp_main_container);
        mTlMain.setTabData(mTabEntities);
        mVpMain.setAdapter(new MyPagerAdapter(context.getSupportFragmentManager()));
        mTlMain.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mVpMain.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTlMain.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mTlMain.setCurrentTab(0);
        mVpMain.setCurrentItem(0);
        //三位数
        mTlMain.showMsg(1, 100);
        mTlMain.setMsgMargin(1, -5, 5);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

}
