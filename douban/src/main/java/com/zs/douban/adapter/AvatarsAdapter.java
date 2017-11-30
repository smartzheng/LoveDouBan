package com.zs.douban.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zs.douban.R;
import com.zs.douban.model.bean.MovieDetailBean;

import java.util.List;

/**
 * Created by smartzheng on 2017/11/29.
 */

public class AvatarsAdapter extends BaseQuickAdapter<MovieDetailBean.AvatarsImageBean, BaseViewHolder> {
    private Context mContext;
    public AvatarsAdapter(Context context, @Nullable List<MovieDetailBean.AvatarsImageBean> data) {
        super(R.layout.item_avatars, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieDetailBean.AvatarsImageBean item) {
        helper.setText(R.id.tv_avatars, item.getAvatarsImageName());
        Glide.with(mContext).load(item.getAvatarsImageUrl()).into((ImageView) helper.getView(R.id.iv_avatars));
    }
}
