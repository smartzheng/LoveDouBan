package com.zs.douban.module.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zs.douban.R;
import com.zs.douban.model.HotModel.SubjectsBean;

import java.util.List;

/**
 * Created by smartzheng on 2017/6/5.
 */

public class hotAdapter extends BaseListAdapter<SubjectsBean> {
    public hotAdapter() {
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


    private String directors2StringBySlash(List<SubjectsBean.DirectorsBean> list) {
        String s = "";
        for (SubjectsBean.DirectorsBean item : list) {
            s += item.getName() + "/";
        }
        return "导演:" + s.substring(0, s.length() - 1);
    }

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

    @Override
    public void addMoreData(List<SubjectsBean> data) {
        getData().addAll(data);
        notifyItemInserted(getData().size());
    }

    @Override
    public void initData(List<SubjectsBean> data) {
        setNewData(data);
    }
}
