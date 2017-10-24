package com.zspt.app.modulecouresdetails.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.model.HomeworkModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/23.
 */

public class HomeworkAdapter extends BaseQuickAdapter<HomeworkModel, BaseViewHolder> {
    private List<HomeworkModel> mData;

    public HomeworkAdapter(@LayoutRes int layoutResId, @Nullable List<HomeworkModel> data) {
        super(layoutResId, data);
        this.mData = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeworkModel item) {
     helper.setText(R.id.item_homework_content,item.getContent())
             .setText(R.id.item_homework_title,item.getTitle())
             .setText(R.id.item_homework_time,item.getTime());
        helper.setText(R.id.item_homework_mark,"已完成");

    }
    public void bindNewData(List<HomeworkModel> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
