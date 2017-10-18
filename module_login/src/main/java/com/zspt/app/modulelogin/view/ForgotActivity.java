package com.zspt.app.modulelogin.view;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulelogin.R;
import com.zspt.app.modulelogin.presenter.ForgotPresenter;

public class ForgotActivity extends BaseMvpActivity implements IForgotView{
    private ForgotPresenter mForgotPresenter;
    private Toolbar mToolbar = null;

    @Override
    protected void onFetchData() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_forgot;
    }

    @Override
    protected void initView() {
        initToolbar();
        mForgotPresenter=new ForgotPresenter(this);
        Button btn=$(R.id.btn_get);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mForgotPresenter.onForgot();
            }
        });

    }

    private void initToolbar() {
        mToolbar = $(R.id.forgot_toolbar);
        mToolbar.setTitle("找回密码");
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

    @Override
    public void onError() {

    }
}
