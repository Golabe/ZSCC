package com.zspt.app.modulemain.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.f_hot.model.HotModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/10.
 */

public class HotAdapter extends BaseQuickAdapter<HotModel, BaseViewHolder> {
    private List<HotModel> mData = new ArrayList<>();

    public HotAdapter(@LayoutRes int layoutResId, @Nullable List<HotModel> data) {
        super(layoutResId, data);
        this.mData = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, HotModel item) {
        helper.setText(R.id.item_hot_name1, item.getName1())
                .setText(R.id.item_hot_name2, item.getName2())
                .setText(R.id.item_hot_name3, item.getName3())
                .setText(R.id.item_hot_name4, item.getName4());
    }

    public void bindNewData(List<HotModel> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();

    }
}
