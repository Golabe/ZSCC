package com.zspt.app.modulemain.splash;

import android.content.Intent;

import com.zspt.app.library_common.base.activity.BaseActivity;
import com.zspt.app.modulemain.MainActivity;

/**
 * Created by yuequan on 2017/10/8.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected int bindLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void initData() {

    }


}
