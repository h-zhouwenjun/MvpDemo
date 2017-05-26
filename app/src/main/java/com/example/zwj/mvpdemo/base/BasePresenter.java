package com.example.zwj.mvpdemo.base;

/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */
public class BasePresenter<V extends BaseView>  implements presenter{
    protected V mRootView;

    public BasePresenter(V rootView) {
        this.mRootView = rootView;
        onStart();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }
}
