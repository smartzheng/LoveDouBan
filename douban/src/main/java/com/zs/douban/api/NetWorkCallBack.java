package com.zs.douban.api;

import com.zs.douban.model.bean.ReadBean;

/**
 * Created by smartzheng on 2017/9/8.
 */

public interface NetWorkCallBack {
    void success(ReadBean model);
    void failed(String msg);
}
