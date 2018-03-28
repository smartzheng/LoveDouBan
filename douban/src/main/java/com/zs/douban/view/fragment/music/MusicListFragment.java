package com.zs.douban.view.fragment.music;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zs.douban.R;
import com.zs.douban.adapter.MusicAdapter;
import com.zs.douban.model.bean.BombMusic;
import com.zs.douban.utils.SwipeRefreshHelper;
import com.zs.douban.utils.Utils;
import com.zs.douban.view.base.BaseListFragment;

import org.json.JSONArray;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

/**
 * Created by smartzheng on 2017/4/3.
 *
 */

public class MusicListFragment extends BaseListFragment<List<BombMusic>>{
    @InjectView(R.id.rv_music)
    RecyclerView mRvMusic;
    private MusicAdapter mMusicAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_music, null);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_music;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        mRvMusic.setLayoutManager(new LinearLayoutManager(MusicListFragment.this.getContext()));
        mMusicAdapter = new MusicAdapter(getContext());
    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    public void initData() {
        SwipeRefreshHelper.controlRefresh(mSrlRoot, true);

        /*
         * 查询数据
         */
        BmobQuery query = new BmobQuery("File");
//        query.addWhereEqualTo("age", 25);
//        query.setLimit(2);
//        query.order("createdAt");
        //v3.5.0版本提供`findObjectsByTable`方法查询自定义表名的数据
        query.findObjectsByTable(new QueryListener<JSONArray>() {
            @Override
            public void done(JSONArray ary, BmobException e) {
                if (e == null) {
                    Log.i("bmob", "查询成功：" + ary.toString());
                    onSuccess(Utils.jsonToArrayList(ary.toString(), BombMusic.class));
                } else {
                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });

    }

    @Override
    public void onFailed() {
        finishLoad();
    }

    @Override
    public void onSuccess(List<BombMusic> bombMusics) {
        mMusicAdapter.setNewData(bombMusics);
        finishLoad();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
