package com.zspt.app.modulecouresdetails.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.model.VoteModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/25.
 */

public class VoteAdapter extends BaseQuickAdapter<VoteModel, BaseViewHolder> {
    private List<VoteModel> mData;

    public VoteAdapter(@LayoutRes int layoutResId, @Nullable List<VoteModel> data) {
        super(layoutResId, data);
        this.mData = data;

    }

    @Override
    protected void convert(BaseViewHolder helper, VoteModel item) {
        helper.setText(R.id.item_vote_title, item.getTitle())
               .setText(R.id.item_vote_count, item.getCount()+"人投票")
                .setText(R.id.item_vote_time, item.getTime());
        Picasso.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.item_vote_image));

    }

    public void bindNewData(List<VoteModel> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
