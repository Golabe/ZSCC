package com.zspt.app.modulemain.f_hot.view;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.zspt.app.library_common.app.AppConstant;
import com.zspt.app.library_common.base.fragment.BaseMvpFragment;
import com.zspt.app.modulemain.R;

import com.zspt.app.modulemain.adapter.HotAdapter;
import com.zspt.app.modulemain.f_hot.PicassoImageLoader;
import com.zspt.app.modulemain.f_hot.model.BannerModel;
import com.zspt.app.modulemain.f_hot.model.HotModel;
import com.zspt.app.modulemain.f_hot.presenter.HotPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/10.
 */

public class HotFragment extends BaseMvpFragment implements IHotView,
        SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.OnItemClickListener,
        OnBannerListener {

    private static final String TAG = "HotFragment";
    private HotPresenter mHotPresenter;
    private boolean mIsLoadMore;
    private int PAGE_COUNT = 1;
    private int mTempPageCount = 2;
    private RecyclerView mHotRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private Banner mBanner;
    private Toolbar mToolbar;
    private List<BannerModel>mBannerData;

    private HotAdapter mHotAdapter;

    @Override
    protected void fetchData() {
        mHotPresenter = new HotPresenter(this);
        mHotPresenter.onBanner();
        mHotPresenter.getHotList();
        addPresenter(mHotPresenter);

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {

        initToolbar();
        mBanner = $(R.id.hot_banner);
        mRefreshLayout = $(R.id.main_swipe_refresh);
        mRefreshLayout.setOnRefreshListener(this);
//        mRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                mRefreshLayout.setRefreshing(true);
//            }
//        });

        mHotRecyclerView = $(R.id.main_recycler);
        mHotAdapter = new HotAdapter(R.layout.item_hot_new, new ArrayList<HotModel>());
        mHotAdapter.setOnItemClickListener(this);

        mHotAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (PAGE_COUNT == mTempPageCount) {
                    return;
                }
                mIsLoadMore = true;
                PAGE_COUNT = mTempPageCount;
                fetchData();
            }
        }, mHotRecyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mHotRecyclerView.setLayoutManager(layoutManager);
        mHotRecyclerView.setAdapter(mHotAdapter);
        mHotAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int i = view.getId();
                if (i == R.id.item_hot_layout1) {
                    ARouter.getInstance().build(AppConstant.MODULE_COURSE_DETAILS).navigation();
                } else if (i == R.id.item_hot_layout2) {
                    ARouter.getInstance().build(AppConstant.MODULE_COURSE_DETAILS).navigation();
                } else if (i == R.id.item_hot_layout3) {
                    ARouter.getInstance().build(AppConstant.MODULE_COURSE_DETAILS).navigation();
                } else if (i == R.id.item_hot_layout4) {
                    ARouter.getInstance().build(AppConstant.MODULE_COURSE_DETAILS).navigation();
                }
            }

        });

        mBanner.setOnBannerListener(this);

    }

    /**
     * 初始化Toolbar
     */
    private void initToolbar() {
        setHasOptionsMenu(true);
        mToolbar = $(R.id.hot_toolbar);
        mToolbar.setTitle("热门");
        mToolbar.setTitleTextColor(Color.BLACK);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
    }

    @Override
    protected void initData() {

    }

    /**
     * 请求错误
     */
    @Override
    public void onError() {
        Log.d(TAG, "onError: ");
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
    public void onSuccess(List<HotModel> data) {
        if (mIsLoadMore) {
            if (data.size() == 0) {

            } else {
                mTempPageCount++;
            }
        } else {

            mHotAdapter.bindNewData(data);
            if (mRefreshLayout.isRefreshing()) {
                mRefreshLayout.setRefreshing(false);
            }
        }
    }

    @Override
    public void onBannerSuccess(List<BannerModel> data) {
        mBannerData=new ArrayList<>();
        mBannerData=data;
        List<String>list=new ArrayList<>();
        for (int i=0;i<data.size();i++){
            list.add(data.get(i).getImageUrl());
        }
        mBanner.setImages(list).setImageLoader(new PicassoImageLoader()).start();
    }

    @Override
    public void onBannerError() {

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
        inflater.inflate(R.menu.menu_hot, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.main_menu_hot_scan) {
            ARouter.getInstance().build(AppConstant.MODULE_SCAN).navigation();
        } else if (i == R.id.main_menu_hot_search) {
            ARouter.getInstance().build(AppConstant.MODULE_SEARCH).navigation();
        } else {

        }
        return true;
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onStart() {
        super.onStart();
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
    }

    /**
     * Banner 点击事件
     *
     * @param position
     */
    @Override
    public void OnBannerClick(int position) {
       ARouter.getInstance().build(AppConstant.MODULE_COURSE_DETAILS)
               .withInt("id",mBannerData.get(position).getId())
               .navigation();
    }
}
