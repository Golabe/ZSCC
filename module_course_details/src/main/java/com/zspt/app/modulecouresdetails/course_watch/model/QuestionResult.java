package com.zspt.app.modulecouresdetails.course_watch.model;

import java.util.List;

/**
 * Created by yuequan on 2017/10/23.
 */

public class QuestionResult {

    /**
     * status : 200
     * message : ok
     * data : [[{"id":1,"catid":1,"title":"java进阶基础","small_img":"","content":"<p>fda<\/p>","read_count":0,"videoList":"Java"},{"id":2,"catid":6,"title":"phph进阶基础","small_img":"","content":"<p>fdsafdsa<\/p>","read_count":0,"videoList":"jQuery"},{"id":3,"catid":3,"title":"fdafa","small_img":"","content":"<p>fdsafds<\/p>","read_count":0,"videoList":"php"},{"id":4,"catid":1,"title":"fdsa","small_img":"","content":"<p>ddsDSFDSAFDA<\/p>","read_count":0,"videoList":"Java"}],[{"id":5,"catid":1,"title":"aas","small_img":"","content":"<p>fdhgfd1111111111ddddaffhgdsffda<\/p>","read_count":0,"videoList":"Java"},{"id":6,"catid":1,"title":"aaaa","small_img":"","content":"<p>dddd<\/p>","read_count":0,"videoList":"Java"},{"id":7,"catid":1,"title":"aaaa","small_img":"","content":"<p>dddd<\/p>","read_count":0,"videoList":"Java"},{"id":8,"catid":1,"title":"aaaa","small_img":"","content":"<p>ddddf&#39;f<\/p>","read_count":0,"videoList":"Java"}],[{"id":9,"catid":1,"title":"aaaa","small_img":"","content":"<p>fdsafdsafdsafdsasda<\/p>","read_count":0,"videoList":"Java"}],[]]
     */

    private int status;
    private String message;
    private List<List<DataBean>> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<List<DataBean>> getData() {
        return data;
    }

    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * catid : 1
         * title : java进阶基础
         * small_img :
         * content : <p>fda</p>
         * read_count : 0
         * videoList : Java
         */

        private int id;
        private int catid;
        private String title;
        private String small_img;
        private String content;
        private int read_count;
        private String videoList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCatid() {
            return catid;
        }

        public void setCatid(int catid) {
            this.catid = catid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSmall_img() {
            return small_img;
        }

        public void setSmall_img(String small_img) {
            this.small_img = small_img;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getRead_count() {
            return read_count;
        }

        public void setRead_count(int read_count) {
            this.read_count = read_count;
        }

        public String getVideoList() {
            return videoList;
        }

        public void setVideoList(String videoList) {
            this.videoList = videoList;
        }
    }
}
