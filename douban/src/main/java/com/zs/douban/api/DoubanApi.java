package com.zs.douban.api;

import com.zs.douban.model.bean.MovieDetailBean;
import com.zs.douban.model.bean.MovieListBean;
import com.zs.douban.model.bean.ReadBean;
import com.zs.douban.utils.Constant;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by smartzheng on 2017/4/4.
 *
 */

public interface DoubanApi {
    @GET(Constant.MOVIE_HOT)
    Observable<MovieListBean> hot(@QueryMap Map<String, Object> params);

    @GET(Constant.MOVIE_COMING)
    Observable<MovieListBean> coming(@QueryMap Map<String, Object> params);

    @GET(Constant.MOVIE_DETAIL)
    Observable<MovieDetailBean> movieDetail(@Path("id") int id);

    @GET(Constant.MOVIE_TOP)
    Observable<MovieListBean> top(@QueryMap Map<String, Object> params);

    @GET(Constant.READ)
    Observable<ReadBean> read(@QueryMap Map<String, Object> params);

   // @GET(Constant.MUSIC)
    //Observable<ReadBean> music(@QueryMap Map<String, Object> params);

}
