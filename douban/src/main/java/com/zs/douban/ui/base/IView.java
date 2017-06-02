package com.zs.douban.ui.base;

/**
 * Created by smartzheng on 2017/4/4.
 */

public interface IView {
    void loadData();
    void onFailed();
    void onSuccess(Object data);
}
