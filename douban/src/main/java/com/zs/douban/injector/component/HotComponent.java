package com.zs.douban.injector.component;

import com.zs.douban.injector.module.HotModule;
import com.zs.douban.module.fragment.movie.hot.HotFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by smartzheng on 2017/6/2.
 *
 */
@Component(modules = HotModule.class)
@Singleton
public interface HotComponent {
    void inject(HotFragment hotFragment);
}
