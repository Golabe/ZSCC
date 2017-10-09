package com.zspt.app.modulemain.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zspt.app.library_common.base.activity.BaseActivity;
import com.zspt.app.modulemain.MainActivity;

/**
 * Created by yuequan on 2017/10/8.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
