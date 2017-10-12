package com.zspt.app.library_common.base.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zspt.app.library_common.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/9.
 */

public abstract class BaseMvpFragment extends BaseFragment {

    protected static final String SUB_TYPE = "subtype";

    protected List<BasePresenter> mPresenters = new ArrayList<>();

    protected abstract void fetchData();

    protected abstract int bindLayoutId();

    protected abstract void initView();

    protected abstract void initData();

//    protected boolean mIsViewInitiated;
//    protected boolean mIsVisibleToUser;
//    protected boolean mIsDataInitiated;
//
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        mIsVisibleToUser = isVisibleToUser;
//        initFetchData();
//    }
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        mIsViewInitiated = true;
//        initFetchData();
//    }
//
//    protected void initFetchData() {
//        if (mIsVisibleToUser && mIsViewInitiated && !mIsDataInitiated) {
//            fetchData();
//            mIsDataInitiated = true;
//        }
//    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fetchData();
    }

    protected void addPresenter(BasePresenter presenter) {
        mPresenters.add(presenter);
    }

    @Override
    public void onDestroy() {
        for (BasePresenter p : mPresenters) {
            p.onDetach();
        }
        super.onDestroy();
    }
}
