package com.zspt.app.modulemain.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zspt.app.modulemain.MainActivity;
import com.zspt.app.modulemain.launcher.LauncherActivity;

/**
 * Created by yuequan on 2017/10/8.
 */

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, LauncherActivity.class));
        finish();

    }
}
