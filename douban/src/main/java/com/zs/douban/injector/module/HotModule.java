package com.zs.douban.injector.module;

import com.zs.douban.ui.fragment.movie.hot.HotFragment;
import com.zs.douban.ui.fragment.movie.hot.HotPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by smartzheng on 2017/6/2.
 */
@Module
public class HotModule {
    private final HotFragment mIView;

    public HotModule(HotFragment view) {
        this.mIView = view;
    }
    @Provides
    @Singleton
    HotPresenter provideHotPresenter(){
        return new HotPresenter(mIView);
    }
}
