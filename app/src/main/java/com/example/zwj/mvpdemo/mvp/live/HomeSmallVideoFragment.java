package com.example.zwj.mvpdemo.mvp.live;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.activity.PhotoViewActivity;
import com.example.zwj.mvpdemo.adapter.HomeSmallVideoAdapter;
import com.example.zwj.mvpdemo.base.BaseFragment;
import com.example.zwj.mvpdemo.bean.GankBean;
import com.example.zwj.mvpdemo.di.component.AppComponent;
import com.example.zwj.mvpdemo.di.component.DaggerHomeSmallVideoComponent;
import com.example.zwj.mvpdemo.di.module.HomeSmallVideoModule;
import com.example.zwj.mvpdemo.service.GankDataService;
import com.example.zwj.mvpdemo.utils.FCLogger;
import com.example.zwj.mvpdemo.utils.ToastUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    private boolean isLoadMore;
    private StaggeredGridLayoutManager layoutManager;
    private View notDataView;
    private View errorView;

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
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        rvSmallVideo.setLayoutManager(layoutManager);
        rvSmallVideo.setItemAnimator(new DefaultItemAnimator());

        homeSmallVideoAdapter = new HomeSmallVideoAdapter(mContext, datas);
        homeSmallVideoAdapter.setOnLoadMoreListener(this, rvSmallVideo);
        homeSmallVideoAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        rvSmallVideo.setAdapter(homeSmallVideoAdapter);

        rvSmallVideo.setHasFixedSize(true);
        initErrorAndNoDataView();
    }

    /**
     * 初始化加载空布局和错误布局
     */
    private void initErrorAndNoDataView() {
        notDataView = mContext.getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) rvSmallVideo.getParent(), false);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshData();
            }
        });
        errorView = mContext.getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) rvSmallVideo.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshData();
            }
        });
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
    protected void lazyFetchData() {
        super.lazyFetchData();
        FCLogger.debug("lazyFetchData");
        swipeLayoutSmallVideo.post(new Runnable() {
            @Override
            public void run() {
                swipeLayoutSmallVideo.setRefreshing(true);
            }
        });
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

    @Override
    public boolean userEventBus() {
        return true;
    }

    /**
     * 刷新成功
     *
     * @param gankBeanList
     */
    @Override
    public void onRefreshSuccess(List<GankBean> gankBeanList) {
        FCLogger.debug("获取数据成功：" + gankBeanList.size());
        isLoadMore = false;
        if (gankBeanList.size() == 0){
            homeSmallVideoAdapter.setEmptyView(notDataView);
            return;
        }
        GankDataService.startService(mContext, gankBeanList);
    }

    /**
     * 加载更多成功
     *
     * @param gankBeanList
     */
    @Override
    public void onLoadMoreSuccess(List<GankBean> gankBeanList) {
        isLoadMore = true;
        GankDataService.startService(mContext, gankBeanList);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dataEvent(List<GankBean> data) {
        if (isLoadMore) {
            if (swipeLayoutSmallVideo != null) {
                swipeLayoutSmallVideo.setEnabled(true);
            }
            if (data.size() == 0) {
                homeSmallVideoAdapter.loadMoreComplete();
            } else {
                pageIndex++;
                homeSmallVideoAdapter.loadMoreComplete();
                homeSmallVideoAdapter.addData(datas.size(), data);
            }
        } else {
            datas.clear();
            datas.addAll(data);
            homeSmallVideoAdapter.setNewData(datas);
            if (data.size() == pageCount) {
                pageIndex += 1;
                homeSmallVideoAdapter.setEnableLoadMore(true);
            }
            swipeLayoutSmallVideo.setRefreshing(false);

        }
    }

    @Override
    public void onRefreshFailed() {
        if (swipeLayoutSmallVideo != null) {
            swipeLayoutSmallVideo.setRefreshing(false);
        }
        homeSmallVideoAdapter.setEmptyView(errorView);
        ToastUtils.showShort("网络异常，请重试");
    }

    @Override
    public void onLoadMoreFailed() {
        if (homeSmallVideoAdapter != null) {
            homeSmallVideoAdapter.loadMoreFail();
        }
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
        homeSmallVideoAdapter.setEmptyView(R.layout.loading_view, (ViewGroup) rvSmallVideo.getParent());
        isLoadMore = false;
        pageIndex = 1;
        mPresenter.getMeiZhiData(mContext, false, "福利", pageCount, pageIndex);
    }

    @Override
    public void onLoadMoreRequested() {
        isLoadMore = true;
        mPresenter.getMeiZhiData(mContext, true, "福利", pageCount, pageIndex);
    }
}
