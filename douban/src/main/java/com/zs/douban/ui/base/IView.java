package com.zs.douban.ui.base;

/**
 * Created by smartzheng on 2017/4/4.
 */

public interface IView<T> {
    void loadData();
    void onFailed();
    void onSuccess(T data);
}
