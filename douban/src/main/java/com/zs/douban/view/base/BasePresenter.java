package com.zs.douban.view.base;

import com.zs.douban.api.DoubanApi;
import com.zs.douban.utils.Constant;

import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by smartzheng on 2017/4/3.
 *
 */

public abstract class BasePresenter<T> {
    protected IView<T> mIView;
    protected static DoubanApi sApi;
    protected BasePresenter() {
        //初始化retrofit
        if(sApi==null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            sApi = retrofit.create(DoubanApi.class);
        }

    }

    /**
     * 获取每个页面对应的Observable
     */
    public abstract Observable<T> getObservable(Map<String, Object> param);
    public void getData(Map<String, Object> param){
        getObservable(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        failed("连接失败");
                    }

                    @Override
                    public void onNext(T response) {
                        success(response);
                    }
                });
    }
    protected  abstract void success(T model);
    protected  abstract void failed(String msg);
    public void initData(){
        getData(initParam());
    }
    public void getMoreData(){
        getData(moreParam());
    }

    protected abstract Map<String,Object> moreParam();

    protected abstract Map<String,Object> initParam();
}
