package com.zs.douban.presenter;

import rx.Observable;

/**
 * Created by smartzheng on 2017/12/8.
 */

public interface IPresenter<T, P> {

    /**
     * 获取每个页面对应的Observable
     */
    Observable<T> getObservable(P param);

    void getData(P param);

    void success(T model);

    void failed(String msg);

    void initData();

    void getMoreData();

    P moreParam();

    P initParam();
}
