package com.zspt.app.modulemain.f_study.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zspt.app.library_common.base.fragment.BaseMvpFragment;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.f_study.presenter.StudyPresenter;

/**
 * Created by yuequan on 2017/10/10.
 */

public class StudyFragment extends BaseMvpFragment implements IStudyView {
private Toolbar mToolbar;
    @Override
    protected void fetchData() {

        StudyPresenter mStudyPresenter=new StudyPresenter(this);

        addPresenter(mStudyPresenter);

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_study;
    }

    @Override
    protected void initView() {
        mToolbar=$(R.id.study_toolbar);

        //初始化Toolbar
        mToolbar.setTitle("最近学习");
        mToolbar.setTitleTextColor(Color.BLACK);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);

        

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onError() {

    }
}
