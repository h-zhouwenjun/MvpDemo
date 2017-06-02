package com.example.zwj.mvpdemo.mvp.live;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.activity.PhotoViewActivity;
import com.example.zwj.mvpdemo.adapter.HomeSmallVideoAdapter;
import com.example.zwj.mvpdemo.base.BaseFragment;
import com.example.zwj.mvpdemo.bean.GankBean;
import com.example.zwj.mvpdemo.di.component.AppComponent;
import com.example.zwj.mvpdemo.di.component.DaggerHomeSmallVideoComponent;
import com.example.zwj.mvpdemo.di.module.HomeSmallVideoModule;
import com.example.zwj.mvpdemo.utils.FCLogger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 小视频
 * <p>
 * <b>创建时间</b> 17/6/1 <br>
 *
 * @author zhouwenjun
 */
public class HomeSmallVideoFragment extends BaseFragment<HomeSmallVideoPresenter> implements HomeSmallVideoContact.View, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.swipeLayout_home_small_video)
    SwipeRefreshLayout swipeLayoutSmallVideo;
    @BindView(R.id.rv_home_small_video)
    RecyclerView rvSmallVideo;
    private HomeSmallVideoAdapter homeSmallVideoAdapter;
    private List<GankBean> datas = new ArrayList<>();
    private int pageCount = 20;
    private int pageIndex = 1;

    public HomeSmallVideoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeSmallVideoFragment newInstance(String param1, String param2) {
        HomeSmallVideoFragment fragment = new HomeSmallVideoFragment();
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
        homeSmallVideoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("url", datas.get(position).url);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(mContext, PhotoViewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView(View rootView) {
        swipeLayoutSmallVideo.setOnRefreshListener(this);
        swipeLayoutSmallVideo.setColorSchemeColors(Color.rgb(47, 223, 189));
        rvSmallVideo.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        homeSmallVideoAdapter = new HomeSmallVideoAdapter(datas, mContext);
        homeSmallVideoAdapter.setOnLoadMoreListener(this, rvSmallVideo);
//        homeSmallVideoAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        rvSmallVideo.setAdapter(homeSmallVideoAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_small_video;
    }

    @Override
    protected void ComponentInject(AppComponent appComponent) {
        DaggerHomeSmallVideoComponent
                .builder()
                .appComponent(appComponent)
                .homeSmallVideoModule(new HomeSmallVideoModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onFirstUserVisible() {
        super.onFirstUserVisible();
        FCLogger.debug("onFirstUserVisible");
        swipeLayoutSmallVideo.setRefreshing(true);
        refreshData();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {
        if (swipeLayoutSmallVideo != null) {
            swipeLayoutSmallVideo.setRefreshing(false);
        }
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void showMsg(int msgId) {

    }

    /**
     * 刷新成功
     *
     * @param gankBeanList
     */
    @Override
    public void onRefreshSuccess(List<GankBean> gankBeanList) {
        FCLogger.debug("获取数据成功：" + gankBeanList.size());
        datas.clear();
        datas.addAll(gankBeanList);
        homeSmallVideoAdapter.setNewData(datas);
        if (gankBeanList.size() == pageCount) {
            pageIndex += 1;
            homeSmallVideoAdapter.setEnableLoadMore(true);
        }
    }

    @Override
    public void onLoadMoreSuccess(List<GankBean> gankBeanList) {
        if (swipeLayoutSmallVideo != null) {
            swipeLayoutSmallVideo.setEnabled(true);
        }
        if (gankBeanList.size() == pageCount) {
            pageIndex += 1;
            homeSmallVideoAdapter.loadMoreEnd(true);
        }
        datas.addAll(gankBeanList);
        homeSmallVideoAdapter.setNewData(datas);
    }

    @Override
    public void onRefreshFailed() {
        if (swipeLayoutSmallVideo != null){
            swipeLayoutSmallVideo.setRefreshing(false);
        }
        Toast.makeText(mContext,"网络异常，请重试",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMoreFailed() {
        if (homeSmallVideoAdapter != null){
            homeSmallVideoAdapter.loadMoreFail();
        }
        Toast.makeText(mContext,"网络异常，请重试",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        FCLogger.debug("正在刷新");
        //禁止上拉加载
        refreshData();
    }

    /**
     * 下拉刷新数据
     */
    private void refreshData() {
        pageIndex = 1;
        homeSmallVideoAdapter.setEnableLoadMore(false);
        mPresenter.getMeiZhiData(mContext, false, "福利", pageCount, pageIndex);
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.getMeiZhiData(mContext, true, "福利", pageCount, pageIndex);
    }
}
