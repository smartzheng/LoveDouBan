package com.zs.douban.presenter;

import com.zs.douban.model.MovieDetailModel;
import com.zs.douban.view.base.BasePresenter;
import com.zs.douban.view.base.IView;

import rx.Observable;

/**
 * Created by smartzheng on 2017/6/2.
 */

public class MovieDetailPresenter extends BasePresenter<MovieDetailModel,Integer> {
    private Integer mId;
    public MovieDetailPresenter(IView<MovieDetailModel> view , int id) {
        mIView = view;
        mId  = id;
    }

    @Override
    public Observable<MovieDetailModel> getObservable(Integer id) {
       return sApi.movieDetail(id);
    }


    @Override
    protected void success(MovieDetailModel model) {
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
