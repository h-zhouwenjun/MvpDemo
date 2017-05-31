package com.example.zwj.mvpdemo.http.api;

import android.content.Context;

import com.example.zwj.mvpdemo.bean.GankBean;
import com.example.zwj.mvpdemo.http.HttpManager;

import java.util.List;

import io.reactivex.Observer;

/**
 * <b>创建时间</b> 17/5/27 <br>
 *
 * @author zhouwenjun
 */

public class GankApi {

    private static GankApi instance;
    private static HttpManager httpManager;

    public static GankApi getInstance(Context context) {
        HttpManager.init(context);
        httpManager = HttpManager.getInstance();
        if (instance == null) {
            synchronized (HttpManager.class) {
                if (instance == null) {
                    instance = new GankApi();
                }
            }
        }
        return instance;
    }

    public void getGankData(Observer<List<GankBean>> subscriber, String type, int count, int page) {
        httpManager.toSubscribe(httpManager.getGankApiService().getGankData(type, count, page), subscriber);
    }
}
