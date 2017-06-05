package com.zs.douban.ui.fragment.movie.hot;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.zs.douban.R;
import com.zs.douban.injector.component.DaggerHotComponent;
import com.zs.douban.injector.module.HotModule;
import com.zs.douban.model.HotModel;
import com.zs.douban.ui.base.BaseFragment;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by smartzheng on 2017/4/3.
 */

public class HotFragment extends BaseFragment<HotModel> {
    @Inject
    HotPresenter mHotPresenter;
    @InjectView(R.id.rl_hot)
    RecyclerView mRlHot;
    @InjectView(R.id.srl_root)
    SwipeRefreshLayout mSrlRoot;


    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initInjector() {
        DaggerHotComponent.builder()
                .hotModule(new HotModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    public void loadData() {
        HashMap<String, String> param = new HashMap<>();
        param.put("city", "成都");
        mHotPresenter.getData(param);
    }

    @Override
    public void onFailed() {

    }

    @Override
    public void onSuccess(HotModel data) {
        //TODO 显示数据
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
