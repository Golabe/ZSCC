package com.zspt.app.modulemain.f_study.view;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zspt.app.library_common.base.fragment.BaseMvpFragment;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.adapter.StudyHistoryAdapter;
import com.zspt.app.modulemain.f_study.model.StudyHistoryModel;
import com.zspt.app.modulemain.f_study.presenter.StudyPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/10.
 */

public class StudyFragment extends BaseMvpFragment implements IStudyView, SwipeRefreshLayout.OnRefreshListener {
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private StudyHistoryAdapter mStudyHistoryAdapter;

    private int PAGE_COUNT = 1;
    private boolean mIsLoadMore;
    private int mTempPageCount = 2;

    @Override
    protected void fetchData() {

        StudyPresenter mStudyPresenter = new StudyPresenter(this);
        mStudyPresenter.getStudyList();
        addPresenter(mStudyPresenter);

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_study;
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
        mRecyclerView = $(R.id.main_recycler);

        mStudyHistoryAdapter = new StudyHistoryAdapter(R.layout.item_study_history, new ArrayList<StudyHistoryModel>());
        mStudyHistoryAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (PAGE_COUNT == mTempPageCount) {
                    return;
                }
                mIsLoadMore = true;
                PAGE_COUNT = mTempPageCount;
                fetchData();
            }
        }, mRecyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mStudyHistoryAdapter);


    }

    private void initToolbar() {
        setHasOptionsMenu(true);
        mToolbar = $(R.id.study_toolbar);
        mToolbar.setTitle("最近学习");
        mToolbar.setTitleTextColor(Color.BLACK);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);

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
    public void onSuccess(List<StudyHistoryModel> data) {
        if (mIsLoadMore) {
            if (data.size() == 0) {

            } else {
                mTempPageCount++;
            }
        } else {
            mStudyHistoryAdapter.bindNewData(data);
            if (mRefreshLayout.isRefreshing()){
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
        fetchData();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_study,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
