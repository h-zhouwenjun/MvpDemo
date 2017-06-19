package com.example.zwj.mvpdemo.mvp.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.base.BaseActivity;
import com.example.zwj.mvpdemo.base.BasePresenter;
import com.example.zwj.mvpdemo.mvp.dynamic.DynamicFragment;
import com.example.zwj.mvpdemo.mvp.live.HomeFragment;
import com.example.zwj.mvpdemo.mvp.message.MessageFragment;
import com.example.zwj.mvpdemo.mvp.mine.MineFragment;
import com.example.zwj.mvpdemo.utils.FCLogger;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */

public class MainPresenter extends BasePresenter<MainContact.View> implements BottomNavigationBar.OnTabSelectedListener {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BottomNavigationBar navigationBar;
    private int lastSelectedPosition = 0;
    private BadgeItem badgeItem;
    private Fragment currentFragment;
    private FragmentManager mFragmentManager;

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
        mFragmentManager = context.getSupportFragmentManager();
        mFragments.add(HomeFragment.newInstance("", ""));
        mFragments.add(DynamicFragment.newInstance("", ""));
        mFragments.add(MessageFragment.newInstance("", ""));
        mFragments.add(MineFragment.newInstance("", ""));
        navigationBar = (BottomNavigationBar) context.obtainView(R.id.bottom_navigation_bar);
        initNavigationBar();
    }

    private void initNavigationBar() {
        badgeItem = new BadgeItem()
                .setBackgroundColorResource(R.color.red)
                .setText("2");
        navigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        navigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        navigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "首页").setActiveColorResource(R.color.orange).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "动态").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "消息").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "我").setActiveColorResource(R.color.brown))
                .setFirstSelectedPosition(lastSelectedPosition > 3 ? 3 : lastSelectedPosition)
                .initialise();
        navigationBar.setTabSelectedListener(this);
        changeFragment(mFragments.get(0));
    }

    @Override
    public void onTabSelected(int position) {
        lastSelectedPosition = position;
        changeFragment(mFragments.get(position));
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    /**
     * Fragment
     *
     * @param targetFragment
     */
    public void changeFragment(Fragment targetFragment) {
        this.changeFragment(R.id.fl_main_container, targetFragment);
    }

    public void changeFragment(int resView, Fragment targetFragment) {
        if (!targetFragment.equals(this.currentFragment)) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            if (!targetFragment.isAdded()) {
                transaction.add(resView, targetFragment, targetFragment.getClass().getSimpleName());
                FCLogger.debug("类名为----" + targetFragment.getClass().getSimpleName());
            }
            if (targetFragment.isHidden()) {
                transaction.show(targetFragment);
            }
            if (this.currentFragment != null && this.currentFragment.isVisible()) {
                transaction.hide(this.currentFragment);
            }
            this.currentFragment = targetFragment;
            transaction.commitAllowingStateLoss();
        }
    }

}
