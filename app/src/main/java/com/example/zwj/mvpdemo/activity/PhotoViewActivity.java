package com.example.zwj.mvpdemo.activity;

import com.bumptech.glide.Glide;
import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.base.BaseActivity;
import com.example.zwj.mvpdemo.di.component.AppComponent;
import com.github.chrisbanes.photoview.PhotoView;

import butterknife.BindView;

public class PhotoViewActivity extends BaseActivity {

    @BindView(R.id.photo_view)
    PhotoView photoView;
    private String url;

    @Override
    protected void ComponentInject(AppComponent appComponent) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        url = getIntent().getStringExtra("url");
        Glide.with(mContext).load(url).into(photoView);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_photo_view;
    }
}
