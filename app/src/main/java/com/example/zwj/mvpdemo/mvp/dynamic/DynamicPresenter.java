package com.example.zwj.mvpdemo.mvp.dynamic;

import com.example.zwj.mvpdemo.base.BasePresenter;

import javax.inject.Inject;

/**
 * <b>创建时间</b> 17/6/16 <br>
 *
 * @author zhouwenjun
 */

public class DynamicPresenter extends BasePresenter<DynamicContact.View>{

    @Inject
    public DynamicPresenter(DynamicContact.View rootView) {
        super(rootView);
    }
}
