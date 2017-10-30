package com.zspt.app.modulecouresdetails.course_watch.view.activity;


import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.library_common.util.hint.ToastUtil;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.presenter.VoteDetailsPresenter;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.interfaces.IVoteDetailsView;

public class VoteDetailsActivity extends BaseMvpActivity implements IVoteDetailsView, View.OnClickListener {
    private Button mOption1, mOption2, mOption3, mOption4;
    private VoteDetailsPresenter mPresenter;

    @Override
    protected void onFetchData() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_vote_details;
    }

    @Override
    protected void initView() {
        mPresenter = new VoteDetailsPresenter(this);
        initToolbar();

        mOption1 = $(R.id.vote_details_option1_btn);
        mOption2 = $(R.id.vote_details_option2_btn);
        mOption3 = $(R.id.vote_details_option3_btn);
        mOption4 = $(R.id.vote_details_option4_btn);

        mOption1.setOnClickListener(this);
        mOption2.setOnClickListener(this);
        mOption3.setOnClickListener(this);
        mOption4.setOnClickListener(this);

    }

    private void initToolbar() {
        Toolbar toolbar = $(R.id.vote_details_toolbar);
        toolbar.setTitle("投票详情");
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.vote_details_option1_btn:
                ToastUtil.showShortToast("hahh");
                setState();
                break;
            case R.id.vote_details_option2_btn:
                setState();
                break;
            case R.id.vote_details_option3_btn:
                setState();
                break;
            case R.id.vote_details_option4_btn:
                setState();
                break;
            default:
                break;
        }
    }

    private void setState() {
        mOption1.setText("10" + "人");
        mOption2.setText("20" + "人");
        mOption3.setText("30" + "人");
        mOption4.setText("40" + "人");
        mOption1.setEnabled(false);
        mOption2.setEnabled(false);
        mOption3.setEnabled(false);
        mOption4.setEnabled(false);
    }
}
