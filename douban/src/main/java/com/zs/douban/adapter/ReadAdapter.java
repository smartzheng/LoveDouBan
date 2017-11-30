package com.zs.douban.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zs.douban.R;
import com.zs.douban.model.bean.ReadBean.BooksBean;
import com.zs.douban.view.base.BaseListAdapter;

import java.util.List;

/**
 * Created by smartzheng on 2017/6/5.
 */

public class ReadAdapter extends BaseListAdapter<BooksBean> {
    public ReadAdapter() {
        super(R.layout.item_read);
    }

    @Override
    protected void convert(BaseViewHolder helper, BooksBean item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_author, authors2StringBySlash(item.getAuthor()))
                .setText(R.id.tv_publisher, "出版社: " + item.getPublisher())
                .setText(R.id.tv_name, "出版时间: " + item.getPubdate());
        Glide.with(mContext).load(item.getImages().getLarge()).into((ImageView) helper.getView(R.id.iv_image));
    }

    /**
     * 连接导演
     *
     * @param list
     * @return
     */
    private String authors2StringBySlash(List<String> list) {
        String s = "";
        for (String item : list) {
            s += item + "/";
        }
        if (s.equals("")) {
            return "作者: 暂无";
        }
        return "作者: " + s.substring(0, s.length() - 1);
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
