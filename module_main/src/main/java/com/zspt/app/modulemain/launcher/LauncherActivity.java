package com.zspt.app.modulemain.launcher;


import android.content.Intent;

import android.icu.text.MessageFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.library_common.util.timer.DownCountTimer;
import com.zspt.app.library_common.util.timer.ICountTimerListener;
import com.zspt.app.modulemain.MainActivity;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.launcher.model.LauncherModel;
import com.zspt.app.modulemain.launcher.presenter.LauncherPresenter;
import com.zspt.app.modulemain.launcher.view.ILauncherView;

public class LauncherActivity extends BaseMvpActivity implements ILauncherView, ICountTimerListener {
    private ImageView mLauncherImage;
    private TextView mTextTimer;
    private DownCountTimer mDownCountTimer;


    @Override
    protected void onFetchData() {
        LauncherPresenter presenter = new LauncherPresenter(this);
        presenter.getData();
        addPresenter(presenter);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_launcher;
    }

    @Override
    protected void initView() {
        mLauncherImage = $(R.id.main_launcher_image);
        mTextTimer = $(R.id.main_launcher_timer);

        mDownCountTimer = new DownCountTimer(this, 3000, 1000);
        mDownCountTimer.start();
        mTextTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, MainActivity.class));
                finish();
            }
        });

        mLauncherImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(LauncherModel data) {
        Picasso.with(this).load(data.getData().getImageUrl()).into(mLauncherImage);
    }

    @Override
    public void onFinish() {

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onTick(long l) {
        if (mTextTimer != null) {
            mTextTimer.setText(l / 1000 + "s");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDownCountTimer != null) {
            mDownCountTimer.cancel();
        }
    }
}
