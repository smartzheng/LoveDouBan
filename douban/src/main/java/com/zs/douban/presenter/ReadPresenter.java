package com.zs.douban.presenter;

import com.zs.douban.model.bean.ReadBean;
import com.zs.douban.presenter.presenter.BasePresenter;
import com.zs.douban.view.base.IView;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * Created by smartzheng on 2017/6/2.
 */

public class ReadPresenter extends BasePresenter<ReadBean,Map<String,Object>> {
    private HashMap<String, Object> param;
    private int mStart = 0;
    public ReadPresenter(IView<ReadBean> view) {
        mIView = view;
        param = new HashMap<>();
    }

    @Override
    public Observable<ReadBean> getObservable(Map<String, Object> param) {
       return sApi.read(param);
    }


    @Override
    protected void success(ReadBean model) {
        mIView.onSuccess(model);
    }

    @Override
    protected void failed(String msg) {

    }

    @Override
    protected Map<String, Object> moreParam() {
        mStart+=20;
        param.put("start", mStart);
        return param;
    }

    @Override
    protected Map<String, Object> initParam() {
        mStart = 10;
        param.put("start", mStart);
        param.put("count", 20);
        return param;
    }
}
