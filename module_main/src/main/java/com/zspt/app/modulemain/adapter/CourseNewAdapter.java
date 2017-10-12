package com.zspt.app.modulemain.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.f_course.model.CourseNewModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/11.
 */

public class CourseNewAdapter<T> extends BaseQuickAdapter<CourseNewModel,BaseViewHolder> {
    private static final String TAG = "CourseNewAdapter";

    public CourseNewAdapter(@LayoutRes int layoutResId, @Nullable List<CourseNewModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CourseNewModel item) {
        Log.d(TAG, "convert: "+item.getLevel());
        helper.setText(R.id.item_course_new_name,item.getName())
                .setText(R.id.item_course_new_count,item.getCount()+"在看")
                .setText(R.id.item_course_new_level,item.getLevel())
                .setImageResource(R.id.item_course_new_image,item.getImageUrl());
    }
    public void addNewData(List<T>data){
        data.clear();
        data.addAll(data);
        notifyDataSetChanged();
    }
}
