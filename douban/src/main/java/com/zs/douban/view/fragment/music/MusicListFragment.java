package com.zs.douban.view.fragment.music;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zs.douban.R;
import com.zs.douban.view.base.BaseListFragment;

import org.json.JSONArray;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

/**
 * Created by smartzheng on 2017/4/3.
 */

public class MusicListFragment extends BaseListFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_music, null);
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
    public void initData() {
        /**
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
                } else {
                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });

    }

    @Override
    public void onFailed() {

    }

    @Override
    public void onSuccess(Object data) {

    }
}
