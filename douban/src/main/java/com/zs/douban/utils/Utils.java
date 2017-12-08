package com.zs.douban.utils;

import android.text.Html;
import android.text.Spanned;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.zs.douban.model.bean.CastsBean;
import com.zs.douban.model.bean.DirectorsBean;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartzheng on 2017/6/6.
 */

public class Utils {
    /**
     * 连接导演
     *
     * @param list
     * @return
     */
    public static String directors2StringBySlash(List<DirectorsBean> list) {
        String s = "";
        for (DirectorsBean item : list) {
            s += item.getName() + "/";
        }
        if (s.equals("")) {
            return "导演：暂无";
        }
        return "导演：" + s.substring(0, s.length() - 1);
    }


    /**
     * 连接演员
     *
     * @param list
     * @return
     */
    public static String casts2StringBySlash(List<CastsBean> list) {
        String s = "";
        for (CastsBean item : list) {
            s += item.getName() + "/";
        }
        if (s.equals("")) {
            return "演员：暂无";
        }
        return "演员：" + s.substring(0, s.length() - 1);
    }

    public static Spanned boldTitle(String s) {
        String title = s.substring(0, s.indexOf("："));
        String content = s.substring(s.indexOf("："), s.length());
        return Html.fromHtml("<b><tt>" + title + "</b></tt>" + content);
    }
    public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> clazz)
    {
        Type type = new TypeToken<ArrayList<JsonObject>>()
        {}.getType();
        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json, type);

        ArrayList<T> arrayList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects)
        {
            arrayList.add(new Gson().fromJson(jsonObject, clazz));
        }
        return arrayList;
    }
}
