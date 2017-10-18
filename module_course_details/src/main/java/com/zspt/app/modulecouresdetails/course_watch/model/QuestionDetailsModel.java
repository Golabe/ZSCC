package com.zspt.app.modulecouresdetails.course_watch.model;

/**
 * Created by yuequan on 2017/10/18.
 */

public class QuestionDetailsModel {
    private String name;
    private String content;
    private String imageUrl;

    public QuestionDetailsModel() {
    }

    public QuestionDetailsModel(String name, String content, String imageUrl) {
        this.name = name;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
