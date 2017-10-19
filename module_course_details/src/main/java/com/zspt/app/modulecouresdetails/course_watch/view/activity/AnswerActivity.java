package com.zspt.app.modulecouresdetails.course_watch.view.activity;

import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zspt.app.library_common.base.activity.BaseActivity;
import com.zspt.app.modulecouresdetails.R;

public class AnswerActivity extends BaseActivity {
    private Toolbar mToolbar;

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_answer;
    }

    @Override
    protected void initView() {
        initToolbar();

    }

    private void initToolbar() {
        mToolbar=$(R.id.answer_toolbar);
        mToolbar.setTitle("回答");
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


}
