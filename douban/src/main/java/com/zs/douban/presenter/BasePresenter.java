package com.zs.douban.presenter;

import com.zs.douban.api.DoubanApi;
import com.zs.douban.utils.Constant;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by smartzheng on 2017/4/3.
 */

public abstract class BasePresenter<T> {
    public static DoubanApi sApi;
    protected BasePresenter() {
        //初始化retrofit
        if(sApi==null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            sApi = retrofit.create(DoubanApi.class);
        }

    }

    /**
     * 获取每个页面对应的Observable
     * @param param
     * @return
     */
    public abstract Observable<T> getObservable(Map<String, String> param);
    public void getData(Map<String, String> param){
        getObservable(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull T module) {
                        success(module);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        failed("访问失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    protected  abstract void success(T module);
    protected  abstract void failed(String msg);
}
