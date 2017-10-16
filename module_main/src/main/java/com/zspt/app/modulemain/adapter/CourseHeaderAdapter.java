package com.zspt.app.modulemain.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.f_course.model.CourseHeaderModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/11.
 */

public class CourseHeaderAdapter extends BaseQuickAdapter<CourseHeaderModel,BaseViewHolder> {
    public CourseHeaderAdapter(@LayoutRes int layoutResId, @Nullable List<CourseHeaderModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CourseHeaderModel item) {

        helper.setText(R.id.item_course_header_type,item.getType())
                .setImageResource(R.id.item_course_header_image,item.getImageId());

    }
    public void bindNewData(){

    }


}
