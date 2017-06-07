package com.zs.douban.module.fragment.movie;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zs.douban.R;
import com.zs.douban.injector.component.DaggerMovieListComponent;
import com.zs.douban.injector.module.MovieListModule;
import com.zs.douban.model.MovieModel;
import com.zs.douban.module.adapter.MovieListAdapter;
import com.zs.douban.module.base.BaseFragment;
import com.zs.douban.module.presenter.MovieListPresenter;
import com.zs.douban.utils.Constant;
import com.zs.douban.utils.SwipeRefreshHelper;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by smartzheng on 2017/4/3.
 */

public class MovieListFragment extends BaseFragment<MovieModel> implements BaseQuickAdapter.RequestLoadMoreListener {
    @Inject
    MovieListPresenter mPresenter;
    @InjectView(R.id.rv_hot)
    RecyclerView mRvHot;
    private int total = 0;
    private boolean isRefresh = true;
    private int currentPage;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_movie_list;
    }

    public MovieListFragment() {

    }

    public static MovieListFragment getInstance(int currentPage) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.PAGE_INDEX, currentPage);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initInjector() {
        DaggerMovieListComponent.builder()
                .movieListModule(new MovieListModule(this,currentPage))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        mRvHot.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new MovieListAdapter();
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

    @Override
    protected void getArgs() {
        currentPage = getArguments().getInt(Constant.PAGE_INDEX);
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
    public void onSuccess(MovieModel data) {
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
