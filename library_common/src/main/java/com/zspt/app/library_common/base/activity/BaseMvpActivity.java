package com.zspt.app.library_common.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zspt.app.library_common.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/9.
 */

public abstract class BaseMvpActivity extends BaseActivity {

    protected List<BasePresenter> mPresenters=new ArrayList<>();

    protected abstract void onFetchData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onFetchData();
    }

    protected void addPresenter(BasePresenter presenter){
        mPresenters.add(presenter);
    }


    @Override
    protected void onDestroy() {
        for (BasePresenter p:mPresenters){
            p.onDetach();
        }
        super.onDestroy();

    }

    protected abstract int bindLayoutId();

    protected abstract void initView();

    protected abstract void initData() ;
}
