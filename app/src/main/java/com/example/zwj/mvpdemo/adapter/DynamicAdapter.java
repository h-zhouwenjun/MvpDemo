package com.example.zwj.mvpdemo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zwj.mvpdemo.R;
import com.example.zwj.mvpdemo.bean.DynamicBean;

import java.util.List;

/**
 * <b>创建时间</b> 17/6/16 <br>
 *
 * @author zhouwenjun
 */

public class DynamicAdapter extends BaseQuickAdapter<DynamicBean, BaseViewHolder> {

    public DynamicAdapter(Context context, @Nullable List<DynamicBean> data) {
        super(R.layout.layout_main_dynamic_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DynamicBean item) {

    }
}
