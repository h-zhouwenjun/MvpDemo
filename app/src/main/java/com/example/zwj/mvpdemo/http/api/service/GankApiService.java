package com.example.zwj.mvpdemo.http.api.service;

import com.example.zwj.mvpdemo.bean.GankBean;
import com.example.zwj.mvpdemo.http.api.ApiResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * <b>创建时间</b> 17/5/27 <br>
 *
 * @author zhouwenjun
 */

public interface GankApiService {

    //http://gank.io/api/data/Android/10/1
    @GET("data/{type}/{count}/{page}")
    Observable<ApiResponse<List<GankBean>>> getGankData(@Path("type") String type, @Path("count") int count, @Path("page") int page);

    //http://gank.io/api/day/2015/08/06
    @GET("day/{year}/{month}/{day}")
    Observable<ApiResponse<GankBean>> getGankDataByDate(@Path("year") String year, @Path("month") String month, @Path("day") String day);
}
