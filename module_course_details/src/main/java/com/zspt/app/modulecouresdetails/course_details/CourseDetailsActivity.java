package com.zspt.app.modulecouresdetails.course_details;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.WatchActivity;


@Route(path = "/ModuleCourseDetails/CourseDetailsActivity")
public class CourseDetailsActivity extends BaseMvpActivity implements View.OnClickListener {

    @Autowired
    String id;
    @Autowired
    int tag;

    private Button mStartStudy;
    private Toolbar mToolbar;

    @Override
    protected void onFetchData() {

    }


    @Override
    protected int bindLayoutId() {
        return R.layout.activity_course_details;
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);

        if (tag == 200) {
            Toast.makeText(this, id + "来自二维码扫描", Toast.LENGTH_SHORT).show();
        }


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_back_48);
        mToolbar.setTitle("Course");
        setSupportActionBar(mToolbar);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mStartStudy = $(R.id.details_start_study);
        mStartStudy.setOnClickListener(this);


        FloatingActionButton mFabCollect = $(R.id.fab_collect);
        mFabCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        FloatingActionButton mFabScan = $(R.id.fab_scan);
        mFabScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_course_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.details_start_study) {
            startActivity(new Intent(CourseDetailsActivity.this, WatchActivity.class));


        } else {
        }
    }
}
