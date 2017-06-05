package com.zs.douban.ui.fragment.movie.hot;

import com.zs.douban.model.HotModel;
import com.zs.douban.presenter.BasePresenter;
import com.zs.douban.ui.base.IView;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by smartzheng on 2017/6/2.
 */

public class HotPresenter extends BasePresenter<HotModel> {
    private IView mIView;

    @Inject
    public HotPresenter(IView view) {
        mIView = view;
    }


    @Override
    public Observable<HotModel> getObservable(Map<String,String> param) {
        return sApi.hot(param);
    }


    @Override
    protected void success(HotModel model) {
        mIView.onSuccess(model);
    }

    @Override
    protected void failed(String msg) {

    }
}
