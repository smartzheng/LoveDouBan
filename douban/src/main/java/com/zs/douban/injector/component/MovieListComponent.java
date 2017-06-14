package com.zs.douban.injector.component;

import com.zs.douban.injector.module.MovieListModule;
import com.zs.douban.view.fragment.movie.MovieListListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by smartzheng on 2017/6/2.
 *
 */
@Component(modules = MovieListModule.class)
@Singleton
public interface MovieListComponent {
    void inject(MovieListListFragment movieListFragment);
}
