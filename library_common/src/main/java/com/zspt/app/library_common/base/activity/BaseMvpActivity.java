package com.zspt.app.library_common.base.activity;

/**
 * Created by yuequan on 2017/10/9.
 */

public abstract class BaseMvpActivity extends BaseActivity {
    protected abstract int bindLayoutId();

    protected abstract void initView();

    protected abstract void initData() ;
}
