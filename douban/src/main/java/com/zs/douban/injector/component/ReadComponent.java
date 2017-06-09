package com.zs.douban.injector.component;

import com.zs.douban.injector.module.ReadModule;
import com.zs.douban.view.fragment.book.ReadFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by smartzheng on 2017/6/2.
 *
 */
@Component(modules = ReadModule.class)
@Singleton
public interface ReadComponent {
    void inject(ReadFragment readFragment);
}
