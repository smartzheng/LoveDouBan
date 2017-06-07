package com.zs.douban.injector.module;

import com.zs.douban.module.fragment.movie.MovieListFragment;
import com.zs.douban.module.presenter.MovieListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by smartzheng on 2017/6/2.
 *
 */
@Module
public class MovieListModule {
    private final MovieListFragment mIView;
    private int pageIndex;

    public MovieListModule(MovieListFragment view,int pageIndex) {
        this.mIView = view;
        this.pageIndex = pageIndex;
    }
    @Provides
    @Singleton
    MovieListPresenter provideMovieListPresenter(){
        return new MovieListPresenter(mIView,pageIndex);
    }
}
