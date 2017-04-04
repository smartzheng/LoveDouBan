package com.zs.douban.presenter;

import com.zs.douban.api.DoubanApi;
import com.zs.douban.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by smartzheng on 2017/4/3.
 */

public class BasePresenter {
    protected static DoubanApi sApi;
    public BasePresenter() {
        //初始化retrofit
        if(sApi==null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            sApi = retrofit.create(DoubanApi.class);
        }

    }
}
