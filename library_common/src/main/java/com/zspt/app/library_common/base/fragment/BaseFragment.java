package com.zspt.app.library_common.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zspt.app.library_common.base.activity.BaseActivity;

/**
 * Created by yuequan on 2017/10/9.
 */

public abstract class BaseFragment extends Fragment {
    protected View mRootView;

    protected BaseActivity mActivity;

    /**
     * 绑定布局id
     *
     * @return
     */
    protected abstract int bindLayoutId();

    /**
     * 初始化相关控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(bindLayoutId(), container, false);

        initView();

        return mRootView;
    }

    public <T extends View> T $(int id) {
        return mRootView.findViewById(id);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
