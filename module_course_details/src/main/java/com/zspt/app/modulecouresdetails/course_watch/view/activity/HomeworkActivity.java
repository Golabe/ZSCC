package com.zspt.app.modulecouresdetails.course_watch.view.activity;


import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.adapter.HomeworkAdapter;
import com.zspt.app.modulecouresdetails.course_watch.model.HomeworkModel;
import com.zspt.app.modulecouresdetails.course_watch.presenter.HomeworkPresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeworkActivity extends BaseMvpActivity implements IHomeworkView, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private HomeworkAdapter mHomeworkAdapter;
    private SwipeRefreshLayout mRefreshLayout;
    private int PAGE_COUNT = 1;
    private boolean mIsLoadMore;
    private int mTempPageCount = 2;

    @Override
    protected void onFetchData() {
        HomeworkPresenter presenter = new HomeworkPresenter(this);
        presenter.getHomeworkList();
        addPresenter(presenter);
    }


    @Override
    protected int bindLayoutId() {
        return R.layout.activity_homework;
    }

    @Override
    protected void initView() {
        initToolbar();
        mRefreshLayout = $(R.id.main_swipe_refresh);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
            }
        });

        mHomeworkAdapter = new HomeworkAdapter(R.layout.item_homework, new ArrayList<HomeworkModel>());
        mHomeworkAdapter.setOnItemClickListener(this);
        mHomeworkAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
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
        mRecyclerView.setAdapter(mHomeworkAdapter);

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
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onSuccess(List<HomeworkModel> data) {
        if (mIsLoadMore) {
            if (data.size() == 0) {

            } else {
                mTempPageCount++;
            }
        } else {
            if (data.size()==0){
                mRefreshLayout.setRefreshing(false);
            }
            mHomeworkAdapter.bindNewData(data);
            if (mRefreshLayout.isRefreshing()) {
                mRefreshLayout.setRefreshing(false);
            }
        }
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        mIsLoadMore = false;
        PAGE_COUNT = 1;
        onFetchData();
    }

    /**
     * adapter 点击事件
     *
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        startActivity(new Intent(HomeworkActivity.this,HomeworkDetailsActivity.class));
    }


}
