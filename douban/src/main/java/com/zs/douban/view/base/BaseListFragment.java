package com.zs.douban.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zs.douban.R;
import com.zs.douban.utils.SwipeRefreshHelper;

import butterknife.InjectView;

/**
 * Created by smartzheng on 2017/4/3.
 *
 */

public abstract class BaseListFragment<T> extends BaseFragment<T> implements IView<T> {
    protected boolean isRefresh = true;
    protected int total;
    @InjectView(R.id.srl_root)
    protected SwipeRefreshLayout mSrlRoot;
    protected BaseListAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (mRootView != null) {
            initSwipeRefresh();
        }
        return view;
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
     * 更新视图控件
     *
     * @param isRefresh 刷新或者加载更多
     */
    protected abstract void updateViews(boolean isRefresh);

    protected void finishLoad() {
        SwipeRefreshHelper.controlRefresh(mSrlRoot, false);
        if (mAdapter != null && mAdapter.isLoading())
            mAdapter.loadMoreComplete();
    }
}
