package com.zs.douban.model.bean;

import java.util.List;

/**
 * Created by smartzheng on 2017/6/7.
 */

public class ReadBean {

    /**
     * books : [{"author":["J.F. DiMarzio"],"id":"3134548","images":{"large":"https://img3.doubanio.com/lpic/s4259006.jpg","medium":"https://img3.doubanio.com/mpic/s4259006.jpg","small":"https://img3.doubanio.com/spic/s4259006.jpg"},"pubdate":"2008-7-30","publisher":"McGraw-Hill Osborne Media","rating":{"average":"5.1","max":10,"min":0,"numRaters":20},"title":"Android","url":"https://api.douban.com/v2/book/3134548"},{"author":["Os Swift"],"id":"26671781","images":{"large":"https://img1.doubanio.com/lpic/s28348439.jpg","medium":"https://img1.doubanio.com/mpic/s28348439.jpg","small":"https://img1.doubanio.com/spic/s28348439.jpg"},"pubdate":"2015-10-2","publisher":"CreateSpace Independent Publishing Platform","rating":{"average":"0.0","max":10,"min":0,"numRaters":0},"title":"Android","url":"https://api.douban.com/v2/book/26671781"},{"author":[],"id":"22159847","images":{"large":"https://img3.doubanio.com/lpic/s25920082.jpg","medium":"https://img3.doubanio.com/mpic/s25920082.jpg","small":"https://img3.doubanio.com/spic/s25920082.jpg"},"pubdate":"","publisher":"Fantasy Flight Games","rating":{"average":"0.0","max":10,"min":0,"numRaters":0},"title":"Android","url":"https://api.douban.com/v2/book/22159847"},{"author":[],"id":"22159845","images":{"large":"https://img3.doubanio.com/lpic/s25920080.jpg","medium":"https://img3.doubanio.com/mpic/s25920080.jpg","small":"https://img3.doubanio.com/spic/s25920080.jpg"},"pubdate":"","publisher":"Fantasy Flight Games","rating":{"average":"0.0","max":10,"min":0,"numRaters":0},"title":"Android","url":"https://api.douban.com/v2/book/22159845"},{"author":["Ward, Paul J."],"id":"21091723","images":{"large":"https://img3.doubanio.com/lpic/s24734632.jpg","medium":"https://img3.doubanio.com/mpic/s24734632.jpg","small":"https://img3.doubanio.com/spic/s24734632.jpg"},"pubdate":"","publisher":"","rating":{"average":"0.0","max":10,"min":0,"numRaters":0},"title":"Android","url":"https://api.douban.com/v2/book/21091723"},{"author":[],"id":"20422669","images":{"large":"https://img1.doubanio.com/lpic/s24500687.jpg","medium":"https://img1.doubanio.com/mpic/s24500687.jpg","small":"https://img1.doubanio.com/spic/s24500687.jpg"},"pubdate":"2013-1","publisher":"Fantasy Flight Games","rating":{"average":"0.0","max":10,"min":0,"numRaters":0},"title":"Android","url":"https://api.douban.com/v2/book/20422669"},{"author":[],"id":"21706894","images":{"large":"https://img1.doubanio.com/lpic/s26090667.jpg","medium":"https://img1.doubanio.com/mpic/s26090667.jpg","small":"https://img1.doubanio.com/spic/s26090667.jpg"},"pubdate":"2013-5","publisher":"Fantasy Flight Games","rating":{"average":"0.0","max":10,"min":0,"numRaters":0},"title":"Android","url":"https://api.douban.com/v2/book/21706894"},{"author":["Deitel, Harvey M.; Deitel, Paul J."],"id":"20524198","images":{"large":"https://img3.doubanio.com/f/shire/5522dd1f5b742d1e1394a17f44d590646b63871d/pics/book-default-large.gif","medium":"https://img1.doubanio.com/f/shire/5522dd1f5b742d1e1394a17f44d590646b63871d/pics/book-default-medium.gif","small":"https://img1.doubanio.com/f/shire/9ec0301cff99c866e9b4f386743f612d594f1836/pics/book-default-small.gif"},"pubdate":"","publisher":"","rating":{"average":"0.0","max":10,"min":0,"numRaters":0},"title":"Android","url":"https://api.douban.com/v2/book/20524198"},{"author":["Eglantine, Cornelia Cecilia"],"id":"19617323","images":{"large":"https://img1.doubanio.com/lpic/s22427148.jpg","medium":"https://img1.doubanio.com/mpic/s22427148.jpg","small":"https://img1.doubanio.com/spic/s22427148.jpg"},"pubdate":"","publisher":"","rating":{"average":"0.0","max":10,"min":0,"numRaters":0},"title":"Android","url":"https://api.douban.com/v2/book/19617323"},{"author":["Humphrey, L. Egaire"],"id":"19785247","images":{"large":"https://img3.doubanio.com/lpic/s22591244.jpg","medium":"https://img3.doubanio.com/mpic/s22591244.jpg","small":"https://img3.doubanio.com/spic/s22591244.jpg"},"pubdate":"","publisher":"","rating":{"average":"0.0","max":10,"min":0,"numRaters":0},"title":"Android","url":"https://api.douban.com/v2/book/19785247"},{"author":["范怀宇"],"id":"11530748","images":{"large":"https://img1.doubanio.com/lpic/s11184539.jpg","medium":"https://img1.doubanio.com/mpic/s11184539.jpg","small":"https://img1.doubanio.com/spic/s11184539.jpg"},"pubdate":"2012-8","publisher":"机械工业出版社","rating":{"average":"8.2","max":10,"min":0,"numRaters":162},"title":"Android开发精要","url":"https://api.douban.com/v2/book/11530748"},{"author":["[美] Bill Phillips","[美] Brian Hardy"],"id":"25848404","images":{"large":"https://img3.doubanio.com/lpic/s28342615.jpg","medium":"https://img3.doubanio.com/mpic/s28342615.jpg","small":"https://img3.doubanio.com/spic/s28342615.jpg"},"pubdate":"2014-4-1","publisher":"人民邮电出版社","rating":{"average":"8.5","max":10,"min":0,"numRaters":197},"title":"Android编程权威指南","url":"https://api.douban.com/v2/book/25848404"},{"author":["姚尚朗","靳岩"],"id":"3770255","images":{"large":"https://img3.doubanio.com/lpic/s3817805.jpg","medium":"https://img3.doubanio.com/mpic/s3817805.jpg","small":"https://img3.doubanio.com/spic/s3817805.jpg"},"pubdate":"2009 年6月","publisher":"人民邮电出版社","rating":{"average":"6.4","max":10,"min":0,"numRaters":241},"title":"Google Android开发入门与实战","url":"https://api.douban.com/v2/book/3770255"},{"author":["邓凡平"],"id":"6802440","images":{"large":"https://img3.doubanio.com/lpic/s11171603.jpg","medium":"https://img3.doubanio.com/mpic/s11171603.jpg","small":"https://img3.doubanio.com/spic/s11171603.jpg"},"pubdate":"2011-9-5","publisher":"机械工业出版社","rating":{"average":"7.9","max":10,"min":0,"numRaters":109},"title":"深入理解Android","url":"https://api.douban.com/v2/book/6802440"},{"author":["罗升阳"],"id":"19986441","images":{"large":"https://img3.doubanio.com/lpic/s27280265.jpg","medium":"https://img3.doubanio.com/mpic/s27280265.jpg","small":"https://img3.doubanio.com/spic/s27280265.jpg"},"pubdate":"2012-10","publisher":"电子工业出版社","rating":{"average":"8.7","max":10,"min":0,"numRaters":47},"title":"Android系统源代码情景分析","url":"https://api.douban.com/v2/book/19986441"},{"author":["丰生强"],"id":"20556210","images":{"large":"https://img3.doubanio.com/lpic/s24870013.jpg","medium":"https://img3.doubanio.com/mpic/s24870013.jpg","small":"https://img3.doubanio.com/spic/s24870013.jpg"},"pubdate":"2013-2","publisher":"人民邮电出版社","rating":{"average":"8.3","max":10,"min":0,"numRaters":90},"title":"Android软件安全与逆向分析","url":"https://api.douban.com/v2/book/20556210"},{"author":["杨丰盛"],"id":"4200822","images":{"large":"https://img1.doubanio.com/lpic/s4143787.jpg","medium":"https://img1.doubanio.com/mpic/s4143787.jpg","small":"https://img1.doubanio.com/spic/s4143787.jpg"},"pubdate":"2010-1","publisher":"机械工业出版社","rating":{"average":"6.6","max":10,"min":0,"numRaters":232},"title":"Android应用开发揭秘","url":"https://api.douban.com/v2/book/4200822"},{"author":["王世江"],"id":"4127895","images":{"large":"https://img1.doubanio.com/lpic/s6089507.jpg","medium":"https://img1.doubanio.com/mpic/s6089507.jpg","small":"https://img1.doubanio.com/spic/s6089507.jpg"},"pubdate":"2009-11","publisher":"人民邮电出版社","rating":{"average":"7.7","max":10,"min":0,"numRaters":122},"title":"Google Android开发入门指南","url":"https://api.douban.com/v2/book/4127895"},{"author":["任玉刚"],"id":"26599538","images":{"large":"https://img3.doubanio.com/lpic/s28283341.jpg","medium":"https://img3.doubanio.com/mpic/s28283341.jpg","small":"https://img3.doubanio.com/spic/s28283341.jpg"},"pubdate":"2015-9-1","publisher":"电子工业出版社","rating":{"average":"8.3","max":10,"min":0,"numRaters":134},"title":"Android开发艺术探索","url":"https://api.douban.com/v2/book/26599538"},{"author":["柯元旦"],"id":"6811238","images":{"large":"https://img3.doubanio.com/lpic/s6937206.jpg","medium":"https://img3.doubanio.com/mpic/s6937206.jpg","small":"https://img3.doubanio.com/spic/s6937206.jpg"},"pubdate":"2011-9","publisher":"电子工业出版社","rating":{"average":"8.0","max":10,"min":0,"numRaters":81},"title":"Android内核剖析","url":"https://api.douban.com/v2/book/6811238"}]
     * count : 20
     * start : 0
     * total : 1025
     */

    private int count;
    private int start;
    private int total;
    private List<BooksBean> books;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public static class BooksBean {
        /**
         * author : ["J.F. DiMarzio"]
         * id : 3134548
         * images : {"large":"https://img3.doubanio.com/lpic/s4259006.jpg","medium":"https://img3.doubanio.com/mpic/s4259006.jpg","small":"https://img3.doubanio.com/spic/s4259006.jpg"}
         * pubdate : 2008-7-30
         * publisher : McGraw-Hill Osborne Media
         * rating : {"average":"5.1","max":10,"min":0,"numRaters":20}
         * title : Android
         * url : https://api.douban.com/v2/book/3134548
         */

        private String id;
        private ImagesBean images;
        private String pubdate;
        private String publisher;
        private RatingBean rating;
        private String title;
        private String url;
        private List<String> author;

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

        public String getPubdate() {
            if (pubdate==null||"".equals(pubdate))
                return "暂无";
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getPublisher() {
            if (publisher==null||"".equals(publisher))
                return "暂无";
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getAuthor() {
            return author;
        }

        public void setAuthor(List<String> author) {
            this.author = author;
        }

        public static class ImagesBean {
            /**
             * large : https://img3.doubanio.com/lpic/s4259006.jpg
             * medium : https://img3.doubanio.com/mpic/s4259006.jpg
             * small : https://img3.doubanio.com/spic/s4259006.jpg
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
             * average : 5.1
             * max : 10
             * min : 0
             * numRaters : 20
             */

            private String average;
            private int max;
            private int min;
            private int numRaters;

            public String getAverage() {
                return average;
            }

            public void setAverage(String average) {
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

            public int getNumRaters() {
                return numRaters;
            }

            public void setNumRaters(int numRaters) {
                this.numRaters = numRaters;
            }
        }
    }
}
