package com.zspt.app.modulecouresdetails.course_watch.view.activity;


import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.presenter.VoteDetailsPresenter;

public class VoteDetailsActivity extends BaseMvpActivity implements IVoteDetailsView {

    @Override
    protected void onFetchData() {
        VoteDetailsPresenter presenter=new VoteDetailsPresenter(this);
        addPresenter(presenter);
    }
    @Override
    protected int bindLayoutId() {
        return R.layout.activity_vote_details;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onError() {

    }
}
