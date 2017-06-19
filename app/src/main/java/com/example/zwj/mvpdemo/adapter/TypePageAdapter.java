package com.example.zwj.mvpdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.zwj.mvpdemo.base.BaseFragment;

import java.util.List;

/**
 * <b>创建时间</b> 17/6/10 <br>
 *
 * @author zhouwenjun
 */

public class TypePageAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;
    private String[] titles;

    public TypePageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(List<BaseFragment> fragments, String[] titles) {
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
