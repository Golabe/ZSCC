package com.zspt.app.modulecouresdetails.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.model.QuestionLevel0;

import java.util.List;

/**
 * Created by yuequan on 2017/10/18.
 */

public class QuestionAdapter extends BaseQuickAdapter<QuestionLevel0,BaseViewHolder> {
    private List<QuestionLevel0>mData;
    public QuestionAdapter(@LayoutRes int layoutResId, @Nullable List<QuestionLevel0> data) {
        super(layoutResId, data);
        this.mData=data;
    }

    @Override
    protected void convert(BaseViewHolder helper, QuestionLevel0 item) {
        helper.setText(R.id.item_question_title,item.getTitle())
                .setText(R.id.item_question_content,item.getContent())
                .setText(R.id.item_question_count,item.getCount()+"回答");
        Picasso.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.item_question_image));
    }

    public void bindNewData(List<QuestionLevel0>data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
