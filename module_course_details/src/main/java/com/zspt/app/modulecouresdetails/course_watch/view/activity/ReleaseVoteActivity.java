package com.zspt.app.modulecouresdetails.course_watch.view.activity;


import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.library_common.util.hint.ToastUtil;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.presenter.ReleaseVotePresenter;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.interfaces.IReleaseVoteView;

public class ReleaseVoteActivity extends BaseMvpActivity  implements IReleaseVoteView {
    private EditText mTitle, mContent, mOption1, mOption2, mOption3, mOption4;
    private Button mRelease;
    private ReleaseVotePresenter mPresenter;

    @Override
    protected void onFetchData() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_release_vote;
    }

    @Override
    protected void initView() {
        mPresenter=new ReleaseVotePresenter(this);
        initToolbar();
        mTitle = $(R.id.release_vote_title);
        mContent = $(R.id.release_vote_content);
        mOption1 = $(R.id.release_vote_option1);
        mOption2 = $(R.id.release_vote_option2);
        mOption3 = $(R.id.release_vote_option3);
        mOption4 = $(R.id.release_vote_option4);
        mRelease = $(R.id.release_vote_release);


        mRelease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEmpty()){

                }else {
                    ToastUtil.showShortToast("投票不能为空");
                }
            }
        });
    }

    private boolean isEmpty() {
        if (isEmpty(mTitle.getText().toString())) {

            return true;
        } else if (isEmpty(mContent.getText().toString())) {
            return true;
        } else if (isEmpty(mOption1.getText().toString())) {
            return true;
        } else if (isEmpty(mOption2.getText().toString())) {
            return true;
        } else if (isEmpty(mOption3.getText().toString())) {
            return true;
        } else if (isEmpty(mOption4.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        } else {
            return false;
        }
    }

    private void initToolbar() {
        Toolbar toolbar = $(R.id.release_vote_toolbar);
        toolbar.setTitle("发起投票");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_48);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onError() {

    }
}
