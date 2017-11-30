package com.zs.douban.utils;

/**
 * Created by smartzheng on 2017/4/3.
 *
 */

public interface Constant {
    String BASEURL = "https://api.douban.com/v2/";
    String MOVIE_HOT = "movie/in_theaters";
    String MOVIE_COMING = "movie/coming_soon";
    String MOVIE_TOP = "movie/top250";
    String READ = "book/search?q=android&fields=id,title,author,images,rating,url,publisher,pubdate";
    //?apikey=0b2bdeda43b5688921839c8ecb20399b&city=北京&client=something&udid=dddddddddddddddddddddd
    String MOVIE_DETAIL = "movie/subject/{id}?apikey=0b2bdeda43b5688921839c8ecb20399b&city=北京&client=something&udid=dddddddddddddddddddddd";
    String MUSIC = "";
    String PAGE_INDEX = "pageIndex" ;
}
