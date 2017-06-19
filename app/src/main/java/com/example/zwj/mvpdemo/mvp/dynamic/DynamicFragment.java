package com.example.zwj.mvpdemo.mvp.dynamic;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.adapter.DynamicAdapter;
import com.example.zwj.mvpdemo.base.BaseFragment;
import com.example.zwj.mvpdemo.bean.DynamicBean;
import com.example.zwj.mvpdemo.di.component.AppComponent;
import com.example.zwj.mvpdemo.di.component.DaggerDynamicComponent;
import com.example.zwj.mvpdemo.di.module.DynamicModule;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 动态
 * <b>创建时间</b> 17/6/16 <br>
 *
 * @author zhouwenjun
 */
public class DynamicFragment extends BaseFragment<DynamicPresenter> implements DynamicContact.View, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @BindView(R.id.rv_dynamic)
    RecyclerView rvDynamic;
    private DynamicAdapter dynamicAdapter;
    private List<DynamicBean> mDynamicData;
    @BindView(R.id.swipeLayout_dynamic)
    SwipeRefreshLayout swipeLayoutDynamic;
    private LinearLayoutManager layoutManager;

    public DynamicFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DynamicFragment newInstance(String param1, String param2) {
        DynamicFragment fragment = new DynamicFragment();
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
        mDynamicData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDynamicData.add(new DynamicBean());
        }
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initView(View rootView) {
        swipeLayoutDynamic.setOnRefreshListener(this);
        swipeLayoutDynamic.setColorSchemeColors(Color.rgb(47, 223, 189));
        layoutManager = new LinearLayoutManager(mContext);
        rvDynamic.setLayoutManager(layoutManager);
        rvDynamic.setItemAnimator(new DefaultItemAnimator());

        dynamicAdapter = new DynamicAdapter(mContext, mDynamicData);
        dynamicAdapter.setOnLoadMoreListener(this, rvDynamic);
        dynamicAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        rvDynamic.setAdapter(dynamicAdapter);
        rvDynamic.setHasFixedSize(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected void ComponentInject(AppComponent appComponent) {
        DaggerDynamicComponent
                .builder()
                .appComponent(appComponent)
                .dynamicModule(new DynamicModule(this))
                .build()
                .inject(this);
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

    @OnClick({R.id.img_title_bar_add_dynamic})
    public void setClickListener(View view) {
        switch (view.getId()) {
            case R.id.img_title_bar_add_dynamic://发布动态

                break;
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMoreRequested() {

    }
}

