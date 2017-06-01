package com.example.zwj.mvpdemo.mvp.live;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.base.BaseFragment;
import com.example.zwj.mvpdemo.di.component.AppComponent;

import butterknife.BindView;

public class HomeTypeFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @BindView(R.id.txt_fragment_name)
    TextView mTxtName;

    public HomeTypeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeTypeFragment newInstance(String param1, String param2) {
        HomeTypeFragment fragment = new HomeTypeFragment();
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
        mTxtName.setText(mParam1 + "---" + mParam2);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_type;
    }

    @Override
    protected void ComponentInject(AppComponent appComponent) {

    }
}
