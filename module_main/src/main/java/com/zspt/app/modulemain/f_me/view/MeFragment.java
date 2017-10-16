package com.zspt.app.modulemain.f_me.view;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;


import com.alibaba.android.arouter.launcher.ARouter;
import com.zspt.app.library_common.app.AppConstant;
import com.zspt.app.library_common.base.fragment.BaseMvpFragment;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.f_me.presenter.MePresenter;

/**
 * Created by yuequan on 2017/10/10.
 */

public class MeFragment extends BaseMvpFragment implements IMeView {
    private Toolbar mToolbar = null;
    private ImageView mLogo;

    @Override
    protected void fetchData() {
        MePresenter presenter = new MePresenter(this);
        addPresenter(presenter);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        initToolbar();
        mLogo=$(R.id.me_user_logo);
        mLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(AppConstant.MODULE_LOGIN).navigation();
            }
        });

    }

    private void initToolbar() {
        mToolbar = $(R.id.me_toolbar);
        if (mToolbar != null) {
            mToolbar.setTitle("我的");
            mToolbar.setTitleTextColor(Color.BLACK);
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        }


    }

    @Override
    protected void initData() {

    }

    @Override
    public void onError() {

    }


}
