package com.zs.douban.module.fragment.movie.coming;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zs.douban.R;
import com.zs.douban.module.base.BaseFragment;

/**
 * Created by smartzheng on 2017/4/3.
 *
 */

public class ComingFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_coming,null);
        return rootView;
    }

    @Override
    protected int attachLayoutRes() {
        return 0;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void onFailed() {

    }

    @Override
    public void onSuccess(Object data) {

    }
}
