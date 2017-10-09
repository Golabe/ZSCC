package com.zspt.app.modulemain.launcher;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.zspt.app.library_common.base.activity.BaseActivity;
import com.zspt.app.modulemain.R;

public class LauncherActivity extends BaseActivity {
    private ImageView mLauncherImage;
    private TextView mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);


        mLauncherImage=$(R.id.main_launcher_image);
        mTimer=$(R.id.main_timer);


    }
}
