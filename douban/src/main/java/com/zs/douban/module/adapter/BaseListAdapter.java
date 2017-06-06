package com.zs.douban.module.adapter;

import android.support.annotation.LayoutRes;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by smartzheng on 2017/6/6.
 */

public abstract class BaseListAdapter<T> extends BaseQuickAdapter<T,BaseViewHolder> {
    protected BaseListAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    public abstract void addMoreData(List<T> data);
    public abstract void initData(List<T> data);
}
