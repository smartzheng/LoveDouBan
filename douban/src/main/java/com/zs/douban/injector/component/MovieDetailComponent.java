package com.zs.douban.injector.component;

import com.zs.douban.injector.module.MovieDetailModule;
import com.zs.douban.view.activity.detail.MovieDetailDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by smartzheng on 2017/6/2.
 *
 */
@Component(modules = MovieDetailModule.class)
@Singleton
public interface MovieDetailComponent {
    void inject(MovieDetailDetailActivity movieDetailActivity);
}
