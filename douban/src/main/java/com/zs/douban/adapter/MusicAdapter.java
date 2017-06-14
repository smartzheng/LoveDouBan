package com.zs.douban.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zs.douban.R;
import com.zs.douban.model.ReadModel.BooksBean;
import com.zs.douban.view.base.BaseListAdapter;

import java.util.List;

/**
 * Created by smartzheng on 2017/6/5.
 */

public class MusicAdapter extends BaseListAdapter<BooksBean> {
    public MusicAdapter() {
        super(R.layout.item_read);
    }

    @Override
    protected void convert(BaseViewHolder helper, BooksBean item) {
        Glide.with(mContext).load(item.getImages().getLarge()).into((ImageView) helper.getView(R.id.iv_image));
    }

    /**
     * 加载更多
     *
     * @param data
     */
    @Override
    public void addMoreData(List<BooksBean> data) {
        getData().addAll(data);
        notifyItemInserted(getData().size());
    }

    /**
     * 首次加载
     *
     * @param data
     */
    @Override
    public void initData(List<BooksBean> data) {
        setNewData(data);
    }
}
