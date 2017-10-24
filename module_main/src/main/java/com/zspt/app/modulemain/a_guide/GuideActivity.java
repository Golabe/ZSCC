package com.zspt.app.modulemain.a_guide;


import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.youth.banner.Banner;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulemain.MainActivity;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.a_guide.model.GuideBannerMode;
import com.zspt.app.modulemain.a_guide.presenter.GuidePresenter;
import com.zspt.app.modulemain.f_hot.PicassoImageLoader;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseMvpActivity implements IGuideView {
    private Banner mBanner;
    private Button mStartApp;

    @Override
    protected void onFetchData() {
        GuidePresenter presenter = new GuidePresenter(this);
        presenter.getBannerData();
        addPresenter(presenter);

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        setSwipeBackEnable(false);
        mBanner = $(R.id.guide_banner);
        mBanner.isAutoPlay(false);
        mStartApp = $(R.id.guide_start_app);
        mStartApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(List<GuideBannerMode> data) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i).getImageUrl());
        }
        mBanner.setImages(list).setImageLoader(new PicassoImageLoader()).start();
    }

    @Override
    public void onError() {

    }


}
