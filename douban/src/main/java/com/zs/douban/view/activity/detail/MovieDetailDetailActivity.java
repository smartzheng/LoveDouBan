package com.zs.douban.view.activity.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zs.douban.R;
import com.zs.douban.adapter.AvatarsAdapter;
import com.zs.douban.adapter.ReviewsAdapter;
import com.zs.douban.injector.component.DaggerMovieDetailComponent;
import com.zs.douban.injector.module.MovieDetailModule;
import com.zs.douban.model.bean.MovieDetailBean;
import com.zs.douban.presenter.MovieDetailPresenter;
import com.zs.douban.utils.Utils;
import com.zs.douban.view.base.IView;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by smartzheng on 2017/4/3.
 */

public class MovieDetailDetailActivity extends AutoLayoutActivity implements IView<MovieDetailBean> {
    @InjectView(R.id.backdrop)
    ImageView mBackdrop;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @InjectView(R.id.appbar)
    AppBarLayout mAppbar;
    @Inject
    MovieDetailPresenter mPresenter;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    @InjectView(R.id.rt_rating)
    RatingBar mRtRating;
    @InjectView(R.id.tv_no_rating)
    TextView mTvNoRating;
    @InjectView(R.id.tv_director)
    TextView mTvDirector;
    @InjectView(R.id.tv_cast)
    TextView mTvCast;
    @InjectView(R.id.tv_name)
    TextView mTvTime;
    @InjectView(R.id.tv_summary)
    TextView mTvSummary;
    @InjectView(R.id.main_content)
    CoordinatorLayout mMainContent;
    @InjectView(R.id.rv_avatars)
    RecyclerView mRvAvatars;
    @InjectView(R.id.rv_reviews)
    RecyclerView mRvReviews;
    @InjectView(R.id.fab_play)
    FloatingActionButton mFabPlay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.inject(this);
        DaggerMovieDetailComponent.builder()
                .movieDetailModule(new MovieDetailModule(this, Integer.valueOf(getIntent().getStringExtra("id"))))
                .build()
                .inject(this);
        initView();
        initData();
    }

    private void initView() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initData() {
        mPresenter.initData();
    }

    @Override
    public void onFailed() {

    }

    @Override
    public void onSuccess(final MovieDetailBean data) {
        //顶部背景
        Glide.with(MovieDetailDetailActivity.this)
                .load(data.getImages().getLarge())
                .crossFade()
                .into(mBackdrop);
        Glide.with(this).load(data.getImages().getLarge()).asBitmap().into(
                new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {

                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                Palette.Swatch swatch = palette.getMutedSwatch();

                                if (swatch != null) {
                                    mCollapsingToolbar.setBackgroundColor(swatch.getRgb());
                                }
                            }
                        });
                    }
                });
        //标题
        mTvTitle.setText(data.getTitle());
        //演员，导演，年代
        mTvCast.setText(Utils.boldTitle(Utils.casts2StringBySlash(data.getCasts())));
        mTvTime.setText(Utils.boldTitle("上映时间：" + data.getYear()));
        mTvDirector.setText(Utils.boldTitle(Utils.directors2StringBySlash(data.getDirectors())));
        //评分
        if (data.getRating().getAverage() == 0) {
            mRtRating.setVisibility(View.GONE);
            mTvNoRating.setVisibility(View.VISIBLE);
        } else {
            mRtRating.setRating((float) (data.getRating().getAverage() / 2.0));
            mRtRating.setVisibility(View.VISIBLE);
            mTvNoRating.setVisibility(View.GONE);
        }
        //影人列表图片
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        setNestedScrollNormal(layoutManager, mRvAvatars);
        mRvAvatars.setAdapter(new AvatarsAdapter(this, data.getAvatarsImage()));
        //简介
        mTvSummary.setText(Utils.boldTitle("简介：" + data.getSummary()));
        //简评
        LinearLayoutManager reviewsLayoutManager = new LinearLayoutManager(this);
        setNestedScrollNormal(reviewsLayoutManager, mRvReviews);
        mRvReviews.setAdapter(new ReviewsAdapter(this, data.getPopular_reviews()));
        setUrl(data.getTrailer_urls(), data.getTitle());
    }

    private void setUrl(final List<String> trailer_urls, final String title) {
        mFabPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trailer_urls != null && trailer_urls.size() > 0) {
                    Intent intent = new Intent(MovieDetailDetailActivity.this, MoviePlayActivity.class);
                    intent.putExtra("url", trailer_urls.get(0));
                    intent.putExtra("title", title);
                    startActivity(intent);
                }
            }
        });
    }

    private void setNestedScrollNormal(LinearLayoutManager layoutManager, RecyclerView rv) {
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        rv.setHasFixedSize(true);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @OnClick(R.id.fab_play)
    public void onViewClicked() {

    }
}
