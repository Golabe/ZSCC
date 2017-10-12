package com.zspt.app.modulemain.f_course.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zspt.app.library_common.base.fragment.BaseMvpFragment;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.adapter.CourseHeaderAdapter;
import com.zspt.app.modulemain.adapter.CourseNewAdapter;
import com.zspt.app.modulemain.f_course.model.CourseHeaderModel;
import com.zspt.app.modulemain.f_course.model.CourseNewModel;
import com.zspt.app.modulemain.f_course.presenter.CoursePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/10.
 */

public class CourseFragment extends BaseMvpFragment implements ICourseView, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemClickListener {
    private static final String TAG = "CourseFragment";
    private CoursePresenter mCoursePresenter;
    private RecyclerView mHeaderRecyclerView;
    private RecyclerView mNewRecyclerView;
    private CourseNewAdapter mCourseNewAdapter;
    private SwipeRefreshLayout mRefreshLayout;
    private int PAGE_COUNT = 1;
    private boolean mIsLoadMore;
    private int mTempPageCount = 2;

    @Override
    protected void fetchData() {

        mCoursePresenter = new CoursePresenter(this);
        mCoursePresenter.getHeaderList();
        mCoursePresenter.getNewList();

        addPresenter(mCoursePresenter);

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_course;
    }

    @Override
    protected void initView() {
        setHasOptionsMenu(true);
        mHeaderRecyclerView = $(R.id.course_header);
        mRefreshLayout = $(R.id.main_swipe_refresh);

        mRefreshLayout.setOnRefreshListener(this);
        //实现首次自动显示加载提示
        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
            }
        });

        mNewRecyclerView = $(R.id.main_recycler);

        mCourseNewAdapter = new CourseNewAdapter(R.layout.item_course_new, new ArrayList<CourseNewModel>());

        mCourseNewAdapter.setOnItemClickListener(this);

        mCourseNewAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (PAGE_COUNT == mTempPageCount) {
                    return;
                }
                mIsLoadMore = true;
                PAGE_COUNT = mTempPageCount;
                fetchData();
            }
        }, mNewRecyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mNewRecyclerView.setLayoutManager(layoutManager);

        mNewRecyclerView.setAdapter(mCourseNewAdapter);

        initHeaderRecycler();

    }

    private void initHeaderRecycler() {
        mHeaderRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    protected void initData() {

    }

    /**
     * 请求失败
     */
    @Override
    public void onError() {

    }

    /**
     * 请求成功
     *
     * @param data
     */
    @Override
    public void onSuccess(List<CourseNewModel> data) {
        if (mIsLoadMore) {
            if (data.size() == 0) {

            } else {
                mTempPageCount++;
            }
        } else {
            Log.d(TAG, "onSuccess: " + data.get(1).getLevel());

            mCourseNewAdapter.bindNewData(data);
            mRefreshLayout.setRefreshing(false);
        }

    }

    /**
     * 绑定头部列表
     *
     * @param data
     */
    @Override
    public void bindHeaderList(List<CourseHeaderModel> data) {
        if (data.size() == 0) {

        } else {
            CourseHeaderAdapter adapter = new CourseHeaderAdapter(R.layout.item_course_header, data);
            mHeaderRecyclerView.setAdapter(adapter);
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
     * RecyclerView Item 点击事件
     *
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ARouter.getInstance().build("/ModuleCourseDetails/CourseDetailsActivity").navigation();
    }
}
