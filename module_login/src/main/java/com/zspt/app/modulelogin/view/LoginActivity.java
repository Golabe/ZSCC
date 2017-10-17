package com.zspt.app.modulelogin.view;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zspt.app.library_common.app.AppConstant;
import com.zspt.app.library_common.base.activity.BaseActivity;
import com.zspt.app.modulelogin.R;
import com.zspt.app.modulelogin.adapter.PagerAdapter;
import com.zspt.app.modulelogin.callback.MyOnPageChangeListener;
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
    private TextView mLogin, mRegister;

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        initToolbar();
        mLogin = $(R.id.login_login);
        mRegister = $(R.id.login_register);

        mViewPager = $(R.id.login_view_pager);
        mFragments = new ArrayList<>();
        mFragments.add(new SignInFragment());
        mFragments.add(new SignUpFragment());
        mAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new MyOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                onSelected(position);
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelected(0);
                mViewPager.setCurrentItem(0);
            }
        });
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelected(1);
                mViewPager.setCurrentItem(1);
            }
        });
    }

    private void onSelected(int position) {
        switch (position) {
            case 0:
                mLogin.setTextColor(getResources().getColor(R.color.colorLogin));
                mLogin.setTextSize(20);

                mRegister.setTextColor(Color.GRAY);
                mRegister.setTextSize(18);

                break;
            case 1:
                mLogin.setTextColor(Color.GRAY);
                mLogin.setTextSize(18);

                mRegister.setTextColor(getResources().getColor(R.color.colorLogin));
                mRegister.setTextSize(20);
                break;
            default:
                break;
        }

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
