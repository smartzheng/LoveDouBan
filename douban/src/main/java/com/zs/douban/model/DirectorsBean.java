package com.zs.douban.model;

/**
 * Created by smartzheng on 2017/6/14.
 */

public class DirectorsBean {
    /**
     * alt : https://movie.douban.com/celebrity/1276787/
     * avatars : {"large":"https://img3.doubanio.com/img/celebrity/large/1351678808.44.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1351678808.44.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1351678808.44.jpg"}
     * id : 1276787
     * name : 申·阿克
     */

    private String alt;
    private AvatarsBeanX avatars;
    private String id;
    private String name;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public AvatarsBeanX getAvatars() {
        return avatars;
    }

    public void setAvatars(AvatarsBeanX avatars) {
        this.avatars = avatars;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class AvatarsBeanX {
        /**
         * large : https://img3.doubanio.com/img/celebrity/large/1351678808.44.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/1351678808.44.jpg
         * small : https://img3.doubanio.com/img/celebrity/small/1351678808.44.jpg
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
}