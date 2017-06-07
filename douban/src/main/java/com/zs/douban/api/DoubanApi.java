package com.zs.douban.api;

import com.zs.douban.model.MovieModel;
import com.zs.douban.model.ReadModel;
import com.zs.douban.utils.Constant;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by smartzheng on 2017/4/4.
 *
 */

public interface DoubanApi {
    @GET(Constant.MOVIE_HOT)
    Observable<MovieModel> hot(@QueryMap Map<String, Object> params);

    @GET(Constant.MOVIE_COMING)
    Observable<MovieModel> coming(@QueryMap Map<String, Object> params);

    @GET(Constant.MOVIE_TOP)
    Observable<MovieModel> top(@QueryMap Map<String, Object> params);

    @GET(Constant.READ)
    Observable<ReadModel> read(@QueryMap Map<String, Object> params);

   // @GET(Constant.MUSIC)
    //Observable<ReadModel> music(@QueryMap Map<String, Object> params);

}
