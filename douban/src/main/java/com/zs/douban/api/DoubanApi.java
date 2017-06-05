package com.zs.douban.api;

import com.zs.douban.model.HotModel;
import com.zs.douban.utils.Constant;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by smartzheng on 2017/4/4.
 */

public interface DoubanApi {
    @GET(Constant.MOVIE_HOT)
    Observable<HotModel> hot(@QueryMap Map<String, String> param);

}
