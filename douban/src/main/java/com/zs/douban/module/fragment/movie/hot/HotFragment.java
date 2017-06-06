package com.zs.douban.module.fragment.movie.hot;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zs.douban.R;
import com.zs.douban.injector.component.DaggerHotComponent;
import com.zs.douban.injector.module.HotModule;
import com.zs.douban.model.HotModel;
import com.zs.douban.module.adapter.hotAdapter;
import com.zs.douban.module.base.BaseFragment;
import com.zs.douban.utils.SwipeRefreshHelper;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by smartzheng on 2017/4/3.
 *
 */

public class HotFragment extends BaseFragment<HotModel> implements BaseQuickAdapter.RequestLoadMoreListener {
    @Inject
    HotPresenter mPresenter;
    @InjectView(R.id.rv_hot)
    RecyclerView mRvHot;
    private int total = 0;
    private boolean isRefresh = true;
    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initInjector() {
        DaggerHotComponent.builder()
                .hotModule(new HotModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        mRvHot.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new hotAdapter();
        mAdapter.setOnLoadMoreListener(this, mRvHot);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mRvHot.setAdapter(mAdapter);
    }

    /**
     * @param isRefresh 刷新或者加载更多
     */
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

    /**
     * 初始化数据
     */
    @Override
    public void initData() {
        SwipeRefreshHelper.controlRefresh(mSrlRoot, true);
        updateViews(true);
    }

    @Override
    public void onFailed() {
        finishLoad();
    }

    @Override
    public void onSuccess(HotModel data) {
        finishLoad();
        total = data.getTotal();
        if (isRefresh) {
            mAdapter.initData(data.getSubjects());
        } else {
            mAdapter.addMoreData(data.getSubjects());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
