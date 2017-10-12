package com.zspt.app.modulemain.f_course.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

public class CourseFragment extends BaseMvpFragment implements ICourseView, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "CourseFragment";

    private CoursePresenter mCoursePresenter;

    private RecyclerView mHeaderRecyclerView;
    private RecyclerView mNewRecyclerView;

    private CourseNewAdapter mCourseNewAdapter;
    private SwipeRefreshLayout mRefreshLayout;

    private List<CourseNewModel> mNewData = new ArrayList<>();


    private int PAGE_COUNT = 1;
    private boolean mIsLoadMore;

    private int mCourseHeaderImageId[] = {
            R.drawable.bg_web_page_64,
            R.drawable.bg_bg_64,
            R.drawable.bg_phone_64,
            R.drawable.bg_sql_64,
            R.drawable.bg_yun_64,
            R.drawable.bg_ui_64,};
    private String mCourseHeaderType[] = {
            "前端开发",
            "后端开发",
            "移动开发",
            "数据库",
            "云计算",
            "UI设计"};
    private List<CourseHeaderModel> mHeaderData;

    @Override
    protected void fetchData() {

        mCoursePresenter = new CoursePresenter(this);
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


        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
            }
        });

        mNewRecyclerView = $(R.id.main_recycler);



//        mCourseNewAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                mIsLoadMore = true;
//                fetchData();
//            }
//        },mNewRecyclerView);

        initNewRecycler();
        initHeaderRecycler();


    }

    private void initNewRecycler() {





    }


    private void initHeaderRecycler() {
        mHeaderRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));

        mHeaderData = new ArrayList<>();

        for (int i = 0; i < mCourseHeaderImageId.length; i++) {

            mHeaderData.add(new CourseHeaderModel(mCourseHeaderImageId[i], mCourseHeaderType[i]));
        }

        CourseHeaderAdapter adapter = new CourseHeaderAdapter(R.layout.item_course_header, mHeaderData);

        mHeaderRecyclerView.setAdapter(adapter);


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
     * @param data
     */
    @Override
    public void onSuccess(List<CourseNewModel> data) {
        if (mIsLoadMore){
            if (data.size()==0){

            }else {

            }
        }else {
            Log.d(TAG, "onSuccess: " + data.get(1).getLevel());
            mNewData=data;
            mRefreshLayout.setRefreshing(false);
            mCourseNewAdapter = new CourseNewAdapter(R.layout.item_course_new,data);
            mNewRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
            mNewRecyclerView.setAdapter(mCourseNewAdapter);
        }



    }

    @Override
    public void onRefresh() {
        mIsLoadMore = false;
        PAGE_COUNT = 1;
        fetchData();
    }
}
