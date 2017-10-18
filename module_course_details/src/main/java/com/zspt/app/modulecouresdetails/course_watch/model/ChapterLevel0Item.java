package com.zspt.app.modulecouresdetails.course_watch.model;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zspt.app.modulecouresdetails.adapter.ChapterAdapter;

/**
 * Created by yuequan on 2017/10/18.
 */

public class ChapterLevel0Item extends AbstractExpandableItem<ChapterLevel1Item>implements MultiItemEntity{
    private String chapter;

    public ChapterLevel0Item(String chapter) {
        this.chapter = chapter;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return ChapterAdapter.TYPE_LEVEL_0;
    }
}
