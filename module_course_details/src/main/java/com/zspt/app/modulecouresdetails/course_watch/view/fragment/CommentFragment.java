package com.zspt.app.modulecouresdetails.course_watch.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zspt.app.library_common.base.fragment.BaseMvpFragment;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.adapter.CommentAdapter;
import com.zspt.app.modulecouresdetails.course_watch.model.CommentModel;
import com.zspt.app.modulecouresdetails.course_watch.presenter.CommentPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/11.
 */

public class CommentFragment extends BaseMvpFragment implements ICommentView, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private CommentAdapter mCommentAdapter;
    private int PAGE_COUNT = 1;
    private boolean mIsLoadMore;
    private int mTempPageCount = 2;

    @Override
    protected void fetchData() {
        CommentPresenter presenter = new CommentPresenter(this);
        presenter.getCommentList();
        addPresenter(presenter);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_comment;
    }

    @Override
    protected void initView() {
        mRefreshLayout = $(R.id.main_swipe_refresh);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
            }
        });
        mCommentAdapter = new CommentAdapter(R.layout.item_comment, new ArrayList<CommentModel>());
        mCommentAdapter.setOnItemClickListener(this);
        mCommentAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
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

        mRecyclerView = $(R.id.main_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mCommentAdapter);

    }

    @Override
    protected void initData() {

    }

    /**
     * 请求失败
     */
    @Override
    public void onError() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
    }

    /**
     * 请求成功
     *
     * @param data
     */
    @Override
    public void onSuccess(List<CommentModel> data) {
        if (mIsLoadMore) {
            if (data.size() == 0) {

            } else {
                mTempPageCount++;
            }
        } else {
            mCommentAdapter.bindNewData(data);
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
        fetchData();
    }

    /**
     * Adapter Item 点击事件
     *
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
