package com.example.zwj.mvpdemo.mvp.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.base.BaseFragment;
import com.example.zwj.mvpdemo.di.component.AppComponent;

import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @BindView(R.id.ll_mine_root)
    LinearLayout mLlMineRoot;

    public MineFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
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

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void ComponentInject(AppComponent appComponent) {

    }

    @OnClick({R.id.rl_mine_info})
    public void setClickListener(View view) {
        switch (view.getId()) {
            case R.id.rl_mine_info:
                showPhotoPopWindow();
                break;
        }
    }

    /**
     * 显示底部图片选择框
     */
    private void showPhotoPopWindow() {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.layout_photo_pop_menu, null);
        //处理popWindow 显示内容
        handleLogic(contentView);
        //创建并显示popWindow
    }

    /**
     * 处理事件逻辑
     *
     * @param contentView
     */
    private void handleLogic(View contentView) {

    }
}
