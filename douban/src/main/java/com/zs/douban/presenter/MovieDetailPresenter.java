package com.zs.douban.presenter;

import com.zs.douban.model.bean.MovieDetailBean;
import com.zs.douban.presenter.presenter.BasePresenter;
import com.zs.douban.view.base.IView;

import rx.Observable;

/**
 * Created by smartzheng on 2017/6/2.
 */

public class MovieDetailPresenter extends BasePresenter<MovieDetailBean,Integer> {
    private Integer mId;
    public MovieDetailPresenter(IView<MovieDetailBean> view , int id) {
        mIView = view;
        mId  = id;
    }

    @Override
    public Observable<MovieDetailBean> getObservable(Integer id) {
       return sApi.movieDetail(id);
    }


    @Override
    protected void success(MovieDetailBean model) {
        mIView.onSuccess(model);
    }

    @Override
    protected void failed(String msg) {

    }

    @Override
    protected Integer moreParam() {
        return null;
    }

    @Override
    protected Integer initParam() {
        return mId;
    }
}
