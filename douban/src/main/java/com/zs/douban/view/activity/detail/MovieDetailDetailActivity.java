package com.zs.douban.view.activity.detail;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.graphics.Palette;
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
import com.zs.douban.injector.component.DaggerMovieDetailComponent;
import com.zs.douban.injector.module.MovieDetailModule;
import com.zs.douban.model.bean.MovieDetailBean;
import com.zs.douban.presenter.MovieDetailPresenter;
import com.zs.douban.utils.Utils;
import com.zs.douban.view.base.IView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

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
    @InjectView(R.id.tv_time)
    TextView mTvTime;
    @InjectView(R.id.main_content)
    CoordinatorLayout mMainContent;

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
        mTvTitle.setText(data.getTitle());
        mTvCast.setText(Utils.casts2StringBySlash(data.getCasts()));
        mTvTime.setText("上映时间: "+data.getYear());
        mTvDirector.setText(Utils.directors2StringBySlash(data.getDirectors()));
        if (data.getRating().getAverage() == 0) {
            mRtRating.setVisibility(View.GONE);
            mTvNoRating.setVisibility(View.VISIBLE);
        } else {
            mRtRating.setRating((float) (data.getRating().getAverage()/2.0));
            mRtRating.setVisibility(View.VISIBLE);
            mTvNoRating.setVisibility(View.GONE);
        }
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
}
