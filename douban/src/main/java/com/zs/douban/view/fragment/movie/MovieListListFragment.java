package com.zs.douban.view.fragment.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zs.douban.R;
import com.zs.douban.injector.component.DaggerMovieListComponent;
import com.zs.douban.injector.module.MovieListModule;
import com.zs.douban.model.bean.MovieListBean;
import com.zs.douban.adapter.MovieListAdapter;
import com.zs.douban.view.activity.detail.MovieDetailDetailActivity;
import com.zs.douban.view.base.BaseListFragment;
import com.zs.douban.presenter.MovieListPresenter;
import com.zs.douban.utils.Constant;
import com.zs.douban.utils.SwipeRefreshHelper;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by smartzheng on 2017/4/3.
 *
 */

public class MovieListListFragment extends BaseListFragment<MovieListBean> implements BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemClickListener {
    @Inject
    MovieListPresenter mPresenter;
    @InjectView(R.id.rv_movie)
    RecyclerView mRecyclerView;
    private int currentPage;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_movie_list;
    }

    public MovieListListFragment() {

    }

    public static MovieListListFragment getInstance(int currentPage) {
        MovieListListFragment fragment = new MovieListListFragment();
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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new MovieListAdapter();
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
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
    public void onSuccess(MovieListBean data) {
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

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(mContext, MovieDetailDetailActivity.class);
        intent.putExtra("id",((MovieListBean.SubjectsBean)adapter.getData().get(position)).getId());
        startActivity(intent);
    }
}
