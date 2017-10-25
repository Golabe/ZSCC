package com.zspt.app.modulecouresdetails.util;

import android.view.View;
import android.widget.ImageView;

import com.zspt.app.modulecouresdetails.R;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by yuequan on 2017/10/11.
 */

public class MoreBottomDialog extends BaseBottomDialog implements View.OnClickListener {
    private ImageView mQuestion, mDownload, mCheckIn, mVote, mHomework, mBrainstorming;

    @Override
    public int getLayoutRes() {
        return R.layout.layout_bottom_dialog;
    }

    @Override
    public void bindView(View v) {

        mQuestion = v.findViewById(R.id.details_watch_question);
        mDownload = v.findViewById(R.id.details_watch_download);
        mCheckIn = v.findViewById(R.id.details_watch_comment);
        mVote = v.findViewById(R.id.details_watch_vote);
        mHomework = v.findViewById(R.id.details_watch_homework);
        mBrainstorming = v.findViewById(R.id.details_watch_brainstorming);

        mQuestion.setOnClickListener(this);
        mDownload.setOnClickListener(this);
        mCheckIn.setOnClickListener(this);
        mVote.setOnClickListener(this);
        mHomework.setOnClickListener(this);
        mBrainstorming.setOnClickListener(this);

    }

    public interface OnItemClickListener {

        void onItemClick(View view);

    }

    public OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view);
        }

    }
}
