package com.zs.douban.ui.fragment.movie.hot;

import com.zs.douban.injector.module.HotModule;
import com.zs.douban.presenter.BasePresenter;
import com.zs.douban.ui.base.IView;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by smartzheng on 2017/6/2.
 */

public class HotPresenter extends BasePresenter<HotModule> {
    private IView mIView;

    @Inject
    public HotPresenter(IView view) {
        mIView = view;
    }


    @Override
    public Observable<HotModule> getObservable(Map<String,String> param) {
        return sApi.hot(param);
    }


    @Override
    protected void success(HotModule module) {
        mIView.onSuccess(module);
    }

    @Override
    protected void failed(String msg) {

    }
}
