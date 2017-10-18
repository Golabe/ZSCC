package com.zspt.app.modulecouresdetails.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.model.CommentModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/18.
 */

public class CommentAdapter extends BaseQuickAdapter<CommentModel, BaseViewHolder> {
    private List<CommentModel> mData;

    public CommentAdapter(@LayoutRes int layoutResId, @Nullable List<CommentModel> data) {
        super(layoutResId, data);
        this.mData = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentModel item) {
        helper.setText(R.id.item_comment_name, item.getName())
                .setText(R.id.item_comment_content, item.getContent())
                .setText(R.id.item_comment_time, item.getTime());
        Picasso.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.item_comment_image));
        helper.addOnClickListener(R.id.item_comment_image);

    }

    public void bindNewData(List<CommentModel> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
