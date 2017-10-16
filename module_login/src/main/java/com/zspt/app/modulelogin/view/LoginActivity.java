package com.zspt.app.modulelogin.view;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zspt.app.library_common.app.AppConstant;
import com.zspt.app.library_common.base.activity.BaseActivity;
import com.zspt.app.modulelogin.R;
import com.zspt.app.modulelogin.adapter.PagerAdapter;
import com.zspt.app.modulelogin.view.fragment.SignInFragment;
import com.zspt.app.modulelogin.view.fragment.SignUpFragment;

import java.util.ArrayList;
import java.util.List;

@Route(path = AppConstant.MODULE_LOGIN)
public class LoginActivity extends BaseActivity {
    private List<Fragment> mFragments;
    private ViewPager mViewPager = null;
    private PagerAdapter mAdapter;

    private Toolbar mToolbar;

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        initToolbar();

        mViewPager = $(R.id.login_view_pager);
        mFragments = new ArrayList<>();
        mFragments.add(new SignInFragment());
        mFragments.add(new SignUpFragment());
        mAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
    }

    private void initToolbar() {
        mToolbar = $(R.id.login_toolbar);
        mToolbar.setTitle("登陆/注册");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_back_48);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

}
