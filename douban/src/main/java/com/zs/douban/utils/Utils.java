package com.zs.douban.utils;

import com.zs.douban.model.CastsBean;
import com.zs.douban.model.DirectorsBean;

import java.util.List;

/**
 * Created by smartzheng on 2017/6/6.
 */

public class Utils {
    /**
     * 连接导演
     * @param list
     * @return
     */
    public static String directors2StringBySlash(List<DirectorsBean> list) {
        String s = "";
        for (DirectorsBean item : list) {
            s += item.getName() + "/";
        }
        if (s.equals("")) {
            return "导演: 暂无";
        }
        return "导演: " + s.substring(0, s.length() - 1);
    }


    /**
     * 连接演员
     * @param list
     * @return
     */
    public static String casts2StringBySlash(List<CastsBean> list) {
        String s = "";
        for (CastsBean item : list) {
            s += item.getName() + "/";
        }
        if (s.equals("")) {
            return "演员: 暂无";
        }
        return "演员: " + s.substring(0, s.length() - 1);
    }

}
