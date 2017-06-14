package com.zs.douban.injector.module;

import com.zs.douban.view.fragment.read.ReadListFragment;
import com.zs.douban.presenter.ReadPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by smartzheng on 2017/6/2.
 *
 */
@Module
public class ReadModule {
    private final ReadListFragment mIView;

    public ReadModule(ReadListFragment view) {
        this.mIView = view;
    }
    @Provides
    @Singleton
    ReadPresenter provideReadPresenter(){
        return new ReadPresenter(mIView);
    }
}
