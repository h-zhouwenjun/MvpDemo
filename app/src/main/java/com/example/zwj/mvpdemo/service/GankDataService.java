package com.example.zwj.mvpdemo.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;

import com.example.zwj.mvpdemo.bean.GankBean;
import com.example.zwj.mvpdemo.utils.ImageLoader;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>创建时间</b> 17/6/8 <br>
 *
 * @author zhouwenjun
 */
public class GankDataService extends IntentService {

    public GankDataService() {
        super("");
    }

    public static void startService(Context context, List<GankBean> datas) {
        Intent intent = new Intent(context, GankDataService.class);
        intent.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) datas);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            return;
        }

        List<GankBean> datas = intent.getParcelableArrayListExtra("data");
        handleGirlItemData(datas);
    }

    private void handleGirlItemData(List<GankBean> datas) {
        if (datas.size() == 0) {
            EventBus.getDefault().post("finish");
            return;
        }
        for (GankBean data : datas) {
            Bitmap bitmap = ImageLoader.load(this, data.url);
            if (bitmap != null) {
                data.itemWidth = bitmap.getWidth();
                data.itemHeight = bitmap.getHeight();
            }
        }
        EventBus.getDefault().post(datas);
    }
}
