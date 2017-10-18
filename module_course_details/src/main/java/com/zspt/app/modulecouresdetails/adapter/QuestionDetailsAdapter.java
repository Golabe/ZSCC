package com.zspt.app.modulecouresdetails.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.model.QuestionDetailsModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/18.
 */

public class QuestionDetailsAdapter extends BaseQuickAdapter<QuestionDetailsModel, BaseViewHolder> {
    private List<QuestionDetailsModel> mData;

    public QuestionDetailsAdapter(@LayoutRes int layoutResId, @Nullable List<QuestionDetailsModel> data) {
        super(layoutResId, data);
        this.mData = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, QuestionDetailsModel item) {
        helper.setText(R.id.item_question_details_three_name, item.getName())
                .setText(R.id.item_question_details_three_content, item.getContent());
        Picasso.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.item_question_details_three_image));
    }

    public void bindNewData(List<QuestionDetailsModel> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
