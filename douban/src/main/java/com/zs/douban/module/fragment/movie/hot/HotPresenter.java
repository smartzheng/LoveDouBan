package com.zs.douban.module.fragment.movie.hot;

import com.zs.douban.model.HotModel;
import com.zs.douban.module.base.IView;
import com.zs.douban.presenter.BasePresenter;

import java.util.Map;

import rx.Observable;

/**
 * Created by smartzheng on 2017/6/2.
 *
 */

public class HotPresenter extends BasePresenter<HotModel> {
    public HotPresenter(IView<HotModel> view) {
        mIView = view;
    }

    @Override
    public Observable<HotModel> getObservable(Map<String,Object> param) {
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
