package com.zspt.app.modulemain.f_hot.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.f_hot.model.HotModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/10.
 */

public class HotAdapter extends BaseMultiItemQuickAdapter<HotModel,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public HotAdapter(List<HotModel> data) {
        super(data);
        addItemType(HotModel.CURRENTLY_STUDY_TYPE, R.layout.item_currently_study);
        addItemType(HotModel.ANDROID_TYPE, R.layout.item_android);
    }

    @Override
    protected void convert(BaseViewHolder helper, HotModel item) {
        switch (helper.getItemViewType()){
            case HotModel.CURRENTLY_STUDY_TYPE:
                break;
            case HotModel.ANDROID_TYPE:
                break;
        }

    }
}
