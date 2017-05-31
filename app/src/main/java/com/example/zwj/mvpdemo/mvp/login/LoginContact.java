package com.example.zwj.mvpdemo.mvp.login;

import com.example.zwj.mvpdemo.base.BaseView;

/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */

public interface LoginContact {

    interface View extends BaseView {
        void setTime(String time);
    }

}
