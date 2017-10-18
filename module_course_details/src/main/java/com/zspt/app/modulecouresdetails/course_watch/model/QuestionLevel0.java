package com.zspt.app.modulecouresdetails.course_watch.model;

/**
 * Created by yuequan on 2017/10/18.
 */

public class QuestionLevel0 {
    private String title;
    private String content;
    private int count;
    private String imageUrl;

    public QuestionLevel0() {
    }

    public QuestionLevel0(String title, String content, int count, String imageUrl) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
