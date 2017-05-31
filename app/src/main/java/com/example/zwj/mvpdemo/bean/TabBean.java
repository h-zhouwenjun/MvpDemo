package com.example.zwj.mvpdemo.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * <b>创建时间</b> 17/5/31 <br>
 *
 * @author zhouwenjun
 */

public class TabBean implements CustomTabEntity{

    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public TabBean(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
