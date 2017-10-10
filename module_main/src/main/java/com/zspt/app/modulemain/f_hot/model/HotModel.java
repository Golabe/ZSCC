package com.zspt.app.modulemain.f_hot.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by yuequan on 2017/10/10.
 */

public class HotModel implements MultiItemEntity {

    public static final int CURRENTLY_STUDY_TYPE = 0;

    public static final int ANDROID_TYPE=2;

    private int itemType;

    public HotModel(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
