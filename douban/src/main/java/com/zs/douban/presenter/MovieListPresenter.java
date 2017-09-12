package com.zs.douban.presenter;

import com.zs.douban.model.bean.MovieListBean;
import com.zs.douban.view.base.IView;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * Created by smartzheng on 2017/6/2.
 */

public class MovieListPresenter extends BasePresenter<MovieListBean,Map<String,Object>> {
    private HashMap<String, Object> param;
    private int mPageIndex;
    private int mStart = 0;

    public MovieListPresenter(IView<MovieListBean> view, int pageIndex) {
        mIView = view;
        this.mPageIndex = pageIndex;
        param = new HashMap<>();
    }

    @Override
    public Observable<MovieListBean> getObservable(Map<String, Object> param) {
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
    protected void success(MovieListBean model) {
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
