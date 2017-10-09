package com.zspt.app.modulemain.launcher;


import android.widget.ImageView;
import android.widget.TextView;

import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulemain.R;

public class LauncherActivity extends BaseMvpActivity {
    private ImageView mLauncherImage;
    private TextView mTimer;

    @Override
    protected void onFetchData() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_launcher;
    }

    @Override
    protected void initView() {
        mLauncherImage=$(R.id.main_launcher_image);
        mTimer=$(R.id.main_timer);
    }

    @Override
    protected void initData() {

    }

}
