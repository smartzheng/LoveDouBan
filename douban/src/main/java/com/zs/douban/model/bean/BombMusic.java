package com.zs.douban.model.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by smartzheng on 2017/12/1.
 */

public class BombMusic extends BmobObject {
    private String name;
    private String art;
    private BmobFile thumbnail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public BmobFile getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(BmobFile thumbnail) {
        this.thumbnail = thumbnail;
    }
}
