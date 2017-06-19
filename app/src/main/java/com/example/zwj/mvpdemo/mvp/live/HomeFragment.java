package com.example.zwj.mvpdemo.mvp.live;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.base.BaseFragment;
import com.example.zwj.mvpdemo.di.component.AppComponent;
import com.example.zwj.mvpdemo.di.component.DaggerHomeComponent;
import com.example.zwj.mvpdemo.di.module.HomeModule;
import com.example.zwj.mvpdemo.utils.FCLogger;


public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContact.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initView(View rootView) {
        FCLogger.debug("HomeFragment---initView");
        mPresenter.initSlidingTab(rootView, mContext);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void ComponentInject(AppComponent appComponent) {
        DaggerHomeComponent
                .builder()
                .appComponent(appComponent)
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void showMsg(int msgId) {

    }
}
