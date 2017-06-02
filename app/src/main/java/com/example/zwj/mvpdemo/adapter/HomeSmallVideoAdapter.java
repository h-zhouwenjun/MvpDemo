package com.example.zwj.mvpdemo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.bean.GankBean;
import com.example.zwj.mvpdemo.utils.DensityUtils;

import java.util.List;

/**
 * <b>创建时间</b> 17/6/1 <br>
 *
 * @author zhouwenjun
 */

public class HomeSmallVideoAdapter extends BaseQuickAdapter<GankBean, BaseViewHolder> {

    private int itemWidth;
    private Context mContext;

    public HomeSmallVideoAdapter(@Nullable List<GankBean> data, Context context) {
        super(R.layout.layout_rv_small_video_item, data);
        this.mContext = context;
        itemWidth = (DensityUtils.getScreenW(mContext) - DensityUtils.dip2px(context, 8)) / 2;
    }

    @Override
    protected void convert(BaseViewHolder helper, GankBean item) {
        ImageView imageView = helper.getView(R.id.img_video_frame);
        imageView.getLayoutParams().height = itemWidth;
        imageView.getLayoutParams().width = itemWidth;
        int limit = 48;
        String text = item.desc.length() > limit ? item.desc.substring(0, limit) +
                "..." : item.desc;
        helper.setText(R.id.txt_video_title,text);
        Glide.with(mContext).load(item.url).centerCrop().into(imageView);
    }
}
