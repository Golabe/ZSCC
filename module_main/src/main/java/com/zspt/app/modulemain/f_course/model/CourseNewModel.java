package com.zspt.app.modulemain.f_course.model;

/**
 * Created by yuequan on 2017/10/11.
 */

public class CourseNewModel {
    private String name;
    private String level;
    private int imageUrl;
    private int count;

    public CourseNewModel(String name, String level, int imageUrl, int count) {
        this.name = name;
        this.level = level;
        this.imageUrl = imageUrl;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
