package com.zspt.app.modulecouresdetails.course_watch.view.activity;


import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.presenter.HomeworkPresenter;

public class HomeworkActivity extends BaseMvpActivity implements IHomeworkView {
    private RecyclerView mRecyclerView;

    @Override
    protected void onFetchData() {
        HomeworkPresenter presenter = new HomeworkPresenter(this);


        addPresenter(presenter);
    }


    @Override
    protected int bindLayoutId() {
        return R.layout.activity_homework;
    }

    @Override
    protected void initView() {
        initToolbar();

    }

    private void initToolbar() {
        Toolbar toolbar = $(R.id.homework_toolbar);
        toolbar.setTitle("作业");
        toolbar.setTitleTextColor(Color.BLACK);
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
