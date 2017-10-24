package com.zspt.app.modulecouresdetails.course_watch.view.activity;


import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;

public class ReleaseVoteActivity extends BaseMvpActivity {

    @Override
    protected void onFetchData() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_release_vote;
    }

    @Override
    protected void initView() {
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar=$(R.id.release_vote_toolbar);
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
}
