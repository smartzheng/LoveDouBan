package com.zs.douban.module.fragment.movie.hot;

import com.zs.douban.model.HotModel;
import com.zs.douban.module.base.IView;
import com.zs.douban.presenter.BasePresenter;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * Created by smartzheng on 2017/6/2.
 *
 */

public class HotPresenter extends BasePresenter<HotModel> {
    private HashMap<String, Object> param;
    private int start = 0;
    public HotPresenter(IView<HotModel> view) {
        mIView = view;
        param = new HashMap<>();
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

    @Override
    protected Map<String, Object> moreParam() {
        start = 0;
        param.put("start", start);
        return param;
    }

    @Override
    protected Map<String, Object> initParam() {
        param.put("start", ++start);
        return param;
    }

}
