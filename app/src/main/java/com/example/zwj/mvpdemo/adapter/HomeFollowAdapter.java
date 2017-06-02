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

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * <b>创建时间</b> 17/6/2 <br>
 *
 * @author zhouwenjun
 */

public class HomeFollowAdapter extends BaseQuickAdapter<GankBean, BaseViewHolder> {

    private Context mContext;
    private String url;
    private int imageW;

    public HomeFollowAdapter(@Nullable List<GankBean> data, Context context) {
        super(R.layout.layout_rv_follow_item, data);
        this.mContext = context;
        imageW = DensityUtils.getScreenW(mContext) - DensityUtils.dip2px(mContext, 4);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankBean item) {
        url = item.url;
        Glide.with(mContext).load(url).bitmapTransform(new CropCircleTransformation(mContext)).into((ImageView) helper.getView(R.id.img_follow_user_head));
        ImageView imageView = helper.getView(R.id.img_follow_user_image);
        imageView.getLayoutParams().width = imageW;
        imageView.getLayoutParams().height = imageW;
        Glide.with(mContext).load(url).override(imageW, imageW).bitmapTransform(new RoundedCornersTransformation(mContext, 2, 0),new CropTransformation(mContext)).into(imageView);
        helper.setText(R.id.txt_follow_user_name, item.who);
    }
}
