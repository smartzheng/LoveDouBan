package com.zs.douban.view.fragment.read;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zs.douban.R;
import com.zs.douban.injector.component.DaggerReadComponent;
import com.zs.douban.injector.module.ReadModule;
import com.zs.douban.model.ReadModel;
import com.zs.douban.adapter.ReadAdapter;
import com.zs.douban.view.base.BaseListFragment;
import com.zs.douban.presenter.ReadPresenter;
import com.zs.douban.utils.SwipeRefreshHelper;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by smartzheng on 2017/4/3.
 *
 *
 */

public class ReadListFragment extends BaseListFragment<ReadModel> implements BaseQuickAdapter.RequestLoadMoreListener  {
    @Inject
    ReadPresenter mPresenter;
    @InjectView(R.id.rv_read)
    RecyclerView mRecyclerView;
    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_read;
    }

    @Override
    protected void initInjector() {
        DaggerReadComponent.builder()
                .readModule(new ReadModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new ReadAdapter();
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        if (isRefresh) {
            this.isRefresh = true;
            mPresenter.initData();
        } else {
            this.isRefresh = false;
            mPresenter.getMoreData();
        }
    }

    @Override
    public void initData() {
        total = 300;
        SwipeRefreshHelper.controlRefresh(mSrlRoot, true);
        updateViews(true);
    }

    @Override
    public void onFailed() {

    }

    @Override
    public void onSuccess(ReadModel data) {
        finishLoad();
        if (isRefresh) {
           mAdapter.initData(data.getBooks());
        } else {
            mAdapter.addMoreData(data.getBooks());
        }
    }


    @Override
    public void onLoadMoreRequested() {
        if (mAdapter.getData().size() < total) {
            updateViews(false);
        } else {
            mAdapter.loadMoreEnd(false);
        }
    }
}
