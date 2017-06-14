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
    String MOVIE_DETAIL = "movie/subject/{id}";
    String MUSIC = "";
    String PAGE_INDEX = "pageIndex" ;
}
