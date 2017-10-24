package com.zspt.app.modulemain.f_course.view.activity;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zspt.app.library_common.app.AppConstant;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.f_course.presenter.CourseClassifyPresenter;

public class CourseClassifyActivity extends BaseMvpActivity implements ICourseClassifyView {
    private static final String TAG = "CourseClassifyActivity";

    @Override
    protected void onFetchData() {
        CourseClassifyPresenter presenter = new CourseClassifyPresenter(this);
        addPresenter(presenter);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_course_classify;
    }

    @Override
    protected void initView() {
        Bundle bundle = this.getIntent().getExtras();
        String title = bundle.getString("title");
        initToolbar(title);

    }

    private void initToolbar(String title) {
        Toolbar toolbar = $(R.id.course_classify_toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_48);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_course_classify,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.menu_course_classify_search) {
            ARouter.getInstance().build(AppConstant.MODULE_SEARCH).navigation();
        }
        return super.onOptionsItemSelected(item);
    }
}
