package com.zs.douban.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.zs.douban.R;
import com.zs.douban.model.bean.BombMusic;
import com.zs.douban.view.base.BaseListAdapter;

import java.util.List;

/**
 * Created by smartzheng on 2017/6/5.
 */

public class MusicAdapter extends BaseListAdapter<BombMusic> {
    public MusicAdapter() {
        super(R.layout.item_music);
    }

    @Override
    protected void convert(BaseViewHolder helper, BombMusic item) {
        helper.setText(R.id.tv_title,item.getName())
                .setText(R.id.tv_player,item.getArt());
        helper.getView(R.id.iv_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /**
     * 加载更多
     *
     * @param data
     */
    @Override
    public void addMoreData(List<BombMusic> data) {
        getData().addAll(data);
        notifyItemInserted(getData().size());
    }

    /**
     * 首次加载
     *
     * @param data
     */
    @Override
    public void initData(List<BombMusic> data) {
        setNewData(data);
    }
}
