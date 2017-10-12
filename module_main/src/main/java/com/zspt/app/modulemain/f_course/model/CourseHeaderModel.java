package com.zspt.app.modulemain.f_course.model;

/**
 * Created by yuequan on 2017/10/11.
 */

public class CourseHeaderModel {


    private int imageId;
    private String type;

    public CourseHeaderModel() {
    }

    public CourseHeaderModel(int imageId, String type) {
        this.imageId = imageId;
        this.type = type;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
