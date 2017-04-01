package com.zs.dagger2demo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhengshuai on 2017/4/1.
 * Component接口:连接@Module和@Inject;@Module和@Provides方法提供了被依赖的对象。
 * Inject在Component接口出现的地方则是指明了需要注入的地方（一般是一个field）。
 * Component接口就是用来把他们连接起来的。
 */
@Component(modules = LoginModule.class)
@Singleton
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
