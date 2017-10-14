package com.zspt.app.modulemain.f_study.model;

/**
 * Created by yuequan on 2017/10/13.
 */

public class StudyHistoryModel {
    private String name;
    private int image;
    private int progress;

    public StudyHistoryModel(String name, int image, int progress) {
        this.name = name;
        this.image = image;
        this.progress = progress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
