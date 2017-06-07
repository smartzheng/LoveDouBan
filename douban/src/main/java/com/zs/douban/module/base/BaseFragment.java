package com.zs.douban.module.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zs.douban.R;
import com.zs.douban.module.adapter.BaseListAdapter;
import com.zs.douban.utils.SwipeRefreshHelper;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by smartzheng on 2017/4/3.
 */

public abstract class BaseFragment<T> extends android.support.v4.app.Fragment implements IView<T> {
    @InjectView(R.id.srl_root)
    protected SwipeRefreshLayout mSrlRoot;
    protected Context mContext;
    //缓存Fragment view
    private View mRootView;
    protected BaseListAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(attachLayoutRes(), null);
            ButterKnife.inject(this, mRootView);
            initInjector();
            initViews();
            initSwipeRefresh();
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 初始化下拉刷新
     */
    private void initSwipeRefresh() {
        if (mSrlRoot != null) {
            SwipeRefreshHelper.init(mSrlRoot, new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    //这个写法不好
                    updateViews(true);
                }
            });
        }
    }

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    protected abstract int attachLayoutRes();

    /**
     * Dagger 注入
     */
    protected abstract void initInjector();

    /**
     * 初始化视图控件
     */
    protected abstract void initViews();

    /**
     * 更新视图控件
     *
     * @param isRefresh 刷新或者加载更多
     */
    protected abstract void updateViews(boolean isRefresh);

    protected void finishLoad() {
        SwipeRefreshHelper.controlRefresh(mSrlRoot, false);
        if (mAdapter.isLoading())
            mAdapter.loadMoreComplete();
    }
}
