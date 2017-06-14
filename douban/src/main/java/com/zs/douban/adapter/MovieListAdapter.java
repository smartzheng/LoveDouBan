package com.zs.douban.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zs.douban.R;
import com.zs.douban.model.MovieModel.SubjectsBean;
import com.zs.douban.view.base.BaseListAdapter;

import java.util.List;

import static com.zs.douban.utils.Utils.casts2StringBySlash;
import static com.zs.douban.utils.Utils.directors2StringBySlash;

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
                .setText(R.id.tv_time, "上映时间: " + item.getYear())
                .setRating(R.id.rt_rating,(float)( item.getRating().getAverage()/2.0));
        if (item.getRating().getAverage()==0){
            helper.getView(R.id.rt_rating).setVisibility(View.INVISIBLE);
            helper.setVisible(R.id.tv_no_rating,true);
        }else {
            helper.getView(R.id.rt_rating).setVisibility(View.VISIBLE);
            helper.setVisible(R.id.tv_no_rating,false);
        }
        Glide.with(mContext).load(item.getImages().getLarge()).into((ImageView) helper.getView(R.id.iv_image));
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
