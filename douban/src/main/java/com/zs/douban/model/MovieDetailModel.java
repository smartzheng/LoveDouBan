package com.zs.douban.model;

import java.util.List;

/**
 * Created by smartzheng on 2017/6/13.
 */

public class MovieDetailModel {

    /**
     * aka : ["9：末世决战","九","Number 9","机器人9号"]
     * alt : https://movie.douban.com/subject/1764796/
     * casts : [{"alt":"https://movie.douban.com/celebrity/1054395/","avatars":{"large":"https://img1.doubanio.com/img/celebrity/large/51597.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/51597.jpg","small":"https://img1.doubanio.com/img/celebrity/small/51597.jpg"},"id":"1054395","name":"伊利亚·伍德"},{"alt":"https://movie.douban.com/celebrity/1016673/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/3996.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/3996.jpg","small":"https://img3.doubanio.com/img/celebrity/small/3996.jpg"},"id":"1016673","name":"詹妮弗·康纳利"},{"alt":"https://movie.douban.com/celebrity/1017907/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/55994.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/55994.jpg","small":"https://img3.doubanio.com/img/celebrity/small/55994.jpg"},"id":"1017907","name":"约翰·C·赖利"},{"alt":"https://movie.douban.com/celebrity/1036321/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/42033.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/42033.jpg","small":"https://img3.doubanio.com/img/celebrity/small/42033.jpg"},"id":"1036321","name":"克里斯托弗·普卢默"}]
     * collect_count : 72596
     * comments_count : 11738
     * countries : ["美国"]
     * directors : [{"alt":"https://movie.douban.com/celebrity/1276787/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/1351678808.44.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1351678808.44.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1351678808.44.jpg"},"id":"1276787","name":"申·阿克"}]
     * douban_site :
     * genres : ["动画","冒险","奇幻"]
     * id : 1764796
     * images : {"large":"https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p494268647.webp","medium":"https://img1.doubanio.com/view/movie_poster_cover/spst/public/p494268647.webp","small":"https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p494268647.webp"}
     * mobile_url : https://movie.douban.com/subject/1764796/mobile
     * original_title : 9
     * rating : {"average":7.4,"max":10,"min":0,"stars":"40"}
     * ratings_count : 58240
     * reviews_count : 295
     * schedule_url :
     * share_url : https://m.douban.com/movie/subject/1764796
     * subtype : movie
     * summary : 机器人9号（伊利亚•伍德 Elijah Wood 饰）突然醒来，发现身边的世界充满危机，四处残败，一片末世景象。9号带着一个画有三个奇怪符号的圆形物体逃到街上，幸遇发明家机器人2号（马丁•兰道 Martin Landau 饰）给自己装上了声音，但2号却不幸被机器怪兽抓走。9号找到了老兵1号（克里斯托弗•普卢默 Christopher Plummer 饰）、机械工5号（约翰•雷利 John C. Reilly 饰）、疯癫画家6号（克里斯品•格拉夫 Crispin Glover 饰）和大力士8号（弗雷德•塔塔绍尔 Fred Tatasciore 饰）。9号与5号擅自出行援救2号，危急时被女武士7号（詹妮佛•康纳利 Jennifer Connelly 饰）救下，但无意中9号却令终极机器兽复活。带着自己从哪里来以及生存使命的问题，9号决定想尽办法制服机器兽，拯救全世界……©豆瓣
     * title : 机器人9号
     * wish_count : 15286
     * year : 2009
     */

    private String alt;
    private int collect_count;
    private int comments_count;
    private String douban_site;
    private String id;
    private ImagesBean images;
    private String mobile_url;
    private String original_title;
    private RatingBean rating;
    private int ratings_count;
    private int reviews_count;
    private String schedule_url;
    private String share_url;
    private String subtype;
    private String summary;
    private String title;
    private int wish_count;
    private String year;
    private List<String> aka;
    private List<CastsBean> casts;
    private List<String> countries;
    private List<DirectorsBean> directors;
    private List<String> genres;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public static class ImagesBean {
        /**
         * large : https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p494268647.webp
         * medium : https://img1.doubanio.com/view/movie_poster_cover/spst/public/p494268647.webp
         * small : https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p494268647.webp
         */

        private String large;
        private String medium;
        private String small;

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }
    }

    public static class RatingBean {
        /**
         * average : 7.4
         * max : 10
         * min : 0
         * stars : 40
         */

        private double average;
        private int max;
        private int min;
        private String stars;

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }
    }



}
