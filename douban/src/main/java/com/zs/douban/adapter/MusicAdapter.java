package com.zs.douban.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.zs.douban.R;
import com.zs.douban.customview.media.IjkVideoView;
import com.zs.douban.model.bean.BombMusic;
import com.zs.douban.view.base.BaseListAdapter;

import java.util.List;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by smartzheng on 2017/6/5.
 *
 */

public class MusicAdapter extends BaseListAdapter<BombMusic> {
    private IjkVideoView mVideoView;
    public MusicAdapter(Context context) {
        super(R.layout.item_music);
        mVideoView = new IjkVideoView(context);
    }

    @Override
    protected void convert(BaseViewHolder helper, final BombMusic item) {
        helper.setText(R.id.tv_title,item.getName())
                .setText(R.id.tv_player,item.getArt());
        helper.getView(R.id.iv_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IjkMediaPlayer.loadLibrariesOnce(null);
                IjkMediaPlayer.native_profileBegin("libijkplayer.so");
//                mVideoView.setHudView(mHudView);
//                AndroidMediaController controller = new AndroidMediaController(this, false);
//                mVideoView.setMediaController(controller);
                mVideoView.setVideoURI(Uri.parse(item.getThumbnail().getUrl()));
                mVideoView.start();
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
