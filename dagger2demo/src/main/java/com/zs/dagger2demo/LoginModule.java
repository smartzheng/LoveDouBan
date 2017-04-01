package com.zs.dagger2demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhengshuai on 2017/4/1.
 * Module专门用来管理被依赖的对象
 */
@Module
public class LoginModule {
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface QualifierA {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface QualifierB {
    }

    //@Singleton注解表明，这个被依赖的对象在应用的生命周期里只有一个实例。利用的scope
    //若要实现全局单例，需要在application里面创建单例的component
    @QualifierA
    @Provides
    @Singleton
    LoginPresenter provideLoginPresenter1() {
        return new LoginPresenter(100);
    }

    @QualifierB
    @Provides
    @Singleton
    LoginPresenter provideLoginPresenter2() {
        return new LoginPresenter(200);
    }
}
