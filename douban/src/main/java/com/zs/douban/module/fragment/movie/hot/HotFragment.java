package com.zs.douban.module.fragment.movie.hot;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zs.douban.R;
import com.zs.douban.injector.component.DaggerHotComponent;
import com.zs.douban.injector.module.HotModule;
import com.zs.douban.model.HotModel;
import com.zs.douban.module.adapter.hotAdapter;
import com.zs.douban.module.base.BaseFragment;
import com.zs.douban.utils.SwipeRefreshHelper;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by smartzheng on 2017/4/3.
 *
 */

public class HotFragment extends BaseFragment<HotModel> {
    @Inject
    HotPresenter mPresenter;
    @InjectView(R.id.rv_hot)
    RecyclerView mRvHot;
    private int start = 0;
    private hotAdapter mAdapter;
    private int count = 0;
    private int total=0;
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
        mRvHot.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("city", "成都");
        if (isRefresh) {
            start = 0;
            param.put("start", start);
            mPresenter.getData(param);
        } else {
            start += 20;
            param.put("start", start);
            mPresenter.getData(param);
        }
    }

    @Override
    public void loadData() {
        updateViews(true);
    }

    @Override
    public void onFailed() {
        SwipeRefreshHelper.controlRefresh(mSrlRoot, false);
    }

    @Override
    public void onSuccess(HotModel data) {
        SwipeRefreshHelper.controlRefresh(mSrlRoot, false);
        total = data.getTotal();
        if (mAdapter == null) {
            mAdapter = new hotAdapter(R.layout.item_movie, data.getSubjects());
            mRvHot.setAdapter(mAdapter);
        } else {
            mAdapter.notifyItemInserted(count);
        }
        count += data.getCount();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
