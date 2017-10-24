package com.zspt.app.modulecouresdetails.course_watch.view.activity;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.presenter.VotePresenter;

public class VoteActivity extends BaseMvpActivity implements IVoteView {
    private FloatingActionButton mFab;

    @Override
    protected void onFetchData() {
        VotePresenter presenter = new VotePresenter(this);
        addPresenter(presenter);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_vote;
    }

    @Override
    protected void initView() {
        initToolbar();
        mFab=$(R.id.vote_fab);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VoteActivity.this,ReleaseVoteActivity.class));
            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = $(R.id.vote_toolbar);
        toolbar.setTitle("投票");
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
