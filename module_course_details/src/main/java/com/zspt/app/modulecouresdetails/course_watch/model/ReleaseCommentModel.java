package com.zspt.app.modulecouresdetails.course_watch.model;

/**
 * Created by yuequan on 2017/10/25.
 */

public class ReleaseCommentModel {
    private String userId;
    private String username;
    private String comment;
    private int courseId;

    public ReleaseCommentModel() {
    }

    public ReleaseCommentModel(String userId, String username, String comment, int courseId) {
        this.userId = userId;
        this.username = username;
        this.comment = comment;
        this.courseId = courseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
