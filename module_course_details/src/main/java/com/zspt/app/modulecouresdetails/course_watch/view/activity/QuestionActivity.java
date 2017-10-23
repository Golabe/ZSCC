package com.zspt.app.modulecouresdetails.course_watch.view.activity;

import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.utils.TextUtils;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.presenter.QuestionActivityPresenter;


public class QuestionActivity extends BaseMvpActivity implements IQuestionActivityView {
    private Toolbar mToolbar;
    private QuestionActivityPresenter mQuestionActivityPresenter;
    private EditText mTitle, mContent;
    private Button mSubmit;

    @Override
    protected void onFetchData() {
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_question;
    }

    @Override
    protected void initView() {
        mQuestionActivityPresenter = new QuestionActivityPresenter(this);
        initToolbar();
        mTitle = $(R.id.question_title);
        mContent = $(R.id.question_content);
        mSubmit = $(R.id.question_submit);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=mTitle.getText().toString();
                String content=mContent.getText().toString();
                if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(content)) {
                    mQuestionActivityPresenter.onSubmit(title,content);
                }
            }
        });
    }

    private void initToolbar() {
        mToolbar = $(R.id.question_toolbar);
        mToolbar.setTitle("提问");
        mToolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_back_48);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
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
