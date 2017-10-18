package com.zspt.app.modulecouresdetails.course_watch.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zspt.app.modulecouresdetails.adapter.ChapterAdapter;

/**
 * Created by yuequan on 2017/10/18.
 */

public class ChapterLevel1Item implements MultiItemEntity {
    private String title;
    private String length;

    public ChapterLevel1Item(String title, String length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public int getItemType() {
        return ChapterAdapter.TYPE_LEVEL_1;
    }
}
