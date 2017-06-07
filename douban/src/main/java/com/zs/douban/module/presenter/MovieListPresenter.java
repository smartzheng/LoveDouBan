package com.zs.douban.module.presenter;

import com.zs.douban.model.MovieModel;
import com.zs.douban.module.base.IView;
import com.zs.douban.module.base.BasePresenter;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * Created by smartzheng on 2017/6/2.
 */

public class MovieListPresenter extends BasePresenter<MovieModel> {
    private HashMap<String, Object> param;
    private int mPageIndex;
    private int mStart = 0;

    public MovieListPresenter(IView<MovieModel> view, int pageIndex) {
        mIView = view;
        this.mPageIndex = pageIndex;
        param = new HashMap<>();
    }

    @Override
    public Observable<MovieModel> getObservable(Map<String, Object> param) {
        switch (mPageIndex) {
            case 0:
                return sApi.hot(param);
            case 1:
                return sApi.coming(param);
            case 2:
                return sApi.top(param);
            default:
                return null;
        }
    }


    @Override
    protected void success(MovieModel model) {
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
        mStart = 0;
        param.put("start", mStart);
        param.put("count", 20);
        return param;
    }
}
