package com.example.zwj.mvpdemo.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.bean.GankBean;
import com.example.zwj.mvpdemo.utils.ImageLoader;
import com.example.zwj.mvpdemo.widget.ScaleImgView;

import java.util.List;

/**
 * <b>创建时间</b> 17/6/1 <br>
 *
 * @author zhouwenjun
 */

public class HomeSmallVideoAdapter extends BaseQuickAdapter<GankBean, BaseViewHolder> {

    private ScaleImgView imageView;
    private String publishedAt;
    private Context mContext;

    public HomeSmallVideoAdapter(Context context, List<GankBean> data) {
        super(R.layout.layout_rv_small_video_item, data);
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankBean item) {
        imageView = helper.getView(R.id.img_video_frame);
//        int limit = 48;
//        String text = item.desc.length() > limit ? item.desc.substring(0, limit) +
//                "..." : item.desc;
        publishedAt = item.publishedAt;
        if (!TextUtils.isEmpty(publishedAt)) {
            String time = publishedAt.split("T")[0];
            helper.setText(R.id.txt_video_title, time);
        }
        imageView.setInitSize(item.itemWidth, item.itemHeight);
        ImageLoader.load(mContext, item.url, imageView);
    }
}
