package com.zspt.app.modulecouresdetails.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.model.HomeworkDetailsModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/24.
 */


public class HomeworkDetailsAdapter extends BaseQuickAdapter<HomeworkDetailsModel, BaseViewHolder> {
    private List<HomeworkDetailsModel> mData;

    public HomeworkDetailsAdapter(@LayoutRes int layoutResId, @Nullable List<HomeworkDetailsModel> data) {
        super(layoutResId, data);
        this.mData = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeworkDetailsModel item) {
        helper.setText(R.id.item_homework_details_title, item.getId()+"、"+item.getName())
                .setText(R.id.item_homework_details_a, "A:"+item.getA())
                .setText(R.id.item_homework_details_b, "B:"+item.getB())
                .setText(R.id.item_homework_details_c, "C:"+item.getC())
                .setText(R.id.item_homework_details_d, "D:"+item.getD());
        helper.addOnClickListener(R.id.item_homework_details_a)
                .addOnClickListener(R.id.item_homework_details_b)
                .addOnClickListener(R.id.item_homework_details_c)
                .addOnClickListener(R.id.item_homework_details_d);
    }

    public void bindNewData(List<HomeworkDetailsModel> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
