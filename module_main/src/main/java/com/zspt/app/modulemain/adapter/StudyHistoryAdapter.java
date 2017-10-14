package com.zspt.app.modulemain.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.f_study.model.StudyHistoryModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/13.
 */

public class StudyHistoryAdapter extends BaseQuickAdapter<StudyHistoryModel, BaseViewHolder> {

    private List<StudyHistoryModel> mData;
    public StudyHistoryAdapter(@LayoutRes int layoutResId, @Nullable List<StudyHistoryModel> data) {
        super(layoutResId, data);
        this.mData = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, StudyHistoryModel item) {
       helper.setText(R.id.item_study_history_name,item.getName())
               .setImageResource(R.id.item_study_history_image,item.getImage())
               .setProgress(R.id.item_study_history_progress,item.getProgress());
    }

    public void bindNewData(List<StudyHistoryModel> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
