package com.zs.douban.api;

import com.zs.douban.injector.module.HotModule;
import com.zs.douban.utils.Constant;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by smartzheng on 2017/4/4.
 */

public interface DoubanApi {
    @GET(Constant.MOVIE_HOT)
    Observable<HotModule> hot(@QueryMap Map<String, String> param);
}
