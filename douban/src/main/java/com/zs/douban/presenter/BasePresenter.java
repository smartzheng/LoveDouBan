package com.zs.douban.presenter;

import com.zs.douban.api.DoubanApi;
import com.zs.douban.utils.Constant;
import com.zs.douban.view.base.IView;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by smartzheng on 2017/4/3.
 *
 */

public abstract class BasePresenter<T,P> implements IPresenter<T,P>{
     IView<T> mIView;
     static DoubanApi sApi;
     BasePresenter() {
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
    @Override
    public void getData(P param){
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
    @Override
    public void initData(){
        getData(initParam());
    }
    @Override
    public void getMoreData(){
        getData(moreParam());
    }

}
