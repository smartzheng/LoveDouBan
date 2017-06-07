package com.zs.douban.module.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zs.douban.R;
import com.zs.douban.model.MovieModel.SubjectsBean;
import com.zs.douban.module.base.BaseListAdapter;

import java.util.List;

/**
 * Created by smartzheng on 2017/6/5.
 */

public class MovieListAdapter extends BaseListAdapter<SubjectsBean> {
    public MovieListAdapter() {
        super(R.layout.item_movie);
    }

    @Override
    protected void convert(BaseViewHolder helper, SubjectsBean item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_director, directors2StringBySlash(item.getDirectors()))
                .setText(R.id.tv_cast, casts2StringBySlash(item.getCasts()))
                .setText(R.id.tv_time, "上映时间:" + item.getYear());
        Glide.with(mContext).load(item.getImages().getLarge()).into((ImageView) helper.getView(R.id.iv_image));
    }

    /**
     * 连接导演
     * @param list
     * @return
     */
    private String directors2StringBySlash(List<SubjectsBean.DirectorsBean> list) {
        String s = "";
        for (SubjectsBean.DirectorsBean item : list) {
            s += item.getName() + "/";
        }
        if (s.equals("")) {
            return "暂无";
        }
        return "导演:" + s.substring(0, s.length() - 1);
    }

    /**
     * 连接演员
     * @param list
     * @return
     */
    private String casts2StringBySlash(List<SubjectsBean.CastsBean> list) {
        String s = "";
        for (SubjectsBean.CastsBean item : list) {
            s += item.getName() + "/";
        }
        if (s.equals("")) {
            return "暂无";
        }
        return "演员:" + s.substring(0, s.length() - 1);
    }

    /**
     * 加载更多
     * @param data
     */
    @Override
    public void addMoreData(List<SubjectsBean> data) {
        getData().addAll(data);
        notifyItemInserted(getData().size());
    }

    /**
     * 首次加载
     * @param data
     */
    @Override
    public void initData(List<SubjectsBean> data) {
        setNewData(data);
    }
}
