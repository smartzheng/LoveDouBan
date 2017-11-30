package com.zs.douban.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zs.douban.R;
import com.zs.douban.customview.GlideCircleTransform;
import com.zs.douban.model.bean.MovieDetailBean;

import java.util.List;

/**
 * Created by smartzheng on 2017/11/29.
 */

public class ReviewsAdapter extends BaseQuickAdapter<MovieDetailBean.PopularReviewsBean, BaseViewHolder> {
    private Context mContext;
    public ReviewsAdapter(Context context, @Nullable List<MovieDetailBean.PopularReviewsBean> data) {
        super(R.layout.item_reviews, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieDetailBean.PopularReviewsBean item) {
        helper.setText(R.id.tv_content, "\t\t"+item.getSummary())
        .setText(R.id.tv_name,item.getAuthor().getName())
        .setRating(R.id.rt_rating,(float)( item.getRating().getValue()))
        .setText(R.id.tv_title,item.getTitle());
        Glide.with(mContext).load(item.getAuthor().getAvatar()).transform(new GlideCircleTransform(mContext)).into((ImageView) helper.getView(R.id.iv_image));
    }
}
