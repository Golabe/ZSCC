package com.zspt.app.modulecouresdetails.course_watch.view.activity;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.adapter.VoteAdapter;
import com.zspt.app.modulecouresdetails.course_watch.model.VoteModel;
import com.zspt.app.modulecouresdetails.course_watch.presenter.VotePresenter;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.interfaces.IVoteView;

import java.util.ArrayList;
import java.util.List;

public class VoteActivity extends BaseMvpActivity implements
        IVoteView,
        View.OnClickListener,
        SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.OnItemClickListener {
    private FloatingActionButton mFab;
    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private VoteAdapter mVoteAdapter;
    private int PAGE_COUNT = 1;
    private boolean mIsLoadMore;
    private int mTempPageCount = 2;

    @Override
    protected void onFetchData() {
        VotePresenter presenter = new VotePresenter(this);
        presenter.getVoteList();
        addPresenter(presenter);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_vote;
    }

    @Override
    protected void initView() {
        initToolbar();
        mFab = $(R.id.vote_fab);
        mRefreshLayout = $(R.id.main_swipe_refresh);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
            }
        });

        mVoteAdapter = new VoteAdapter(R.layout.item_vote, new ArrayList<VoteModel>());
        mVoteAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (PAGE_COUNT == mTempPageCount) {
                    return;
                }
                mIsLoadMore = true;
                PAGE_COUNT = mTempPageCount;
                onFetchData();
            }
        }, mRecyclerView);

        mRecyclerView = $(R.id.main_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mVoteAdapter);
        mVoteAdapter.setOnItemClickListener(this);
        mFab.setOnClickListener(this);
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
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.vote_fab:
                startActivity(new Intent(VoteActivity.this, ReleaseVoteActivity.class));
                break;
        }
    }

    @Override
    public void onRefresh() {
        mIsLoadMore = false;
        PAGE_COUNT = 1;
        onFetchData();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        startActivity(new Intent(mContext, VoteDetailsActivity.class));
    }

    @Override
    public void onSuccess(List<VoteModel> data) {
        if (mIsLoadMore) {
            if (data.size() == 0) {

            } else {
                mTempPageCount++;
            }
        } else {
            if (data.size() == 0) {
                mRefreshLayout.setRefreshing(false);
            }
            mVoteAdapter.bindNewData(data);
            if (mRefreshLayout.isRefreshing()) {
                mRefreshLayout.setRefreshing(false);
            }
        }

    }
}
