package com.zs.douban.module.base;

/**
 * Created by smartzheng on 2017/4/4.
 *
 *
 */

public interface IView<T> {
    void initData();
    void onFailed();
    void onSuccess(T data);
}
