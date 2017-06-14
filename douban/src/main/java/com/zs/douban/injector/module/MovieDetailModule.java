package com.zs.douban.injector.module;

import com.zs.douban.presenter.MovieDetailPresenter;
import com.zs.douban.view.activity.detail.MovieDetailDetailActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by smartzheng on 2017/6/2.
 *
 */
@Module
public class MovieDetailModule {
    private final MovieDetailDetailActivity mIView;
    private int mId;

    public MovieDetailModule(MovieDetailDetailActivity view, int id) {
        this.mIView = view;
        this.mId = id;
    }
    @Provides
    @Singleton
    MovieDetailPresenter provideMovieDetailPresenter(){
        return new MovieDetailPresenter(mIView,mId);
    }
}
