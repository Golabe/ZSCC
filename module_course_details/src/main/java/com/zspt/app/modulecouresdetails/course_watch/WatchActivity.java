package com.zspt.app.modulecouresdetails.course_watch;


import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Toast;

import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.util.MoreBottomDialog;


public class WatchActivity extends BaseMvpActivity implements View.OnClickListener, MoreBottomDialog.OnItemClickListener {
    private FloatingActionButton mFab;

    @Override
    protected void onFetchData() {

    }


    @Override
    protected int bindLayoutId() {
        return R.layout.activity_watch;
    }

    @Override
    protected void initView() {
        mFab = $(R.id.details_watch_fab);
        mFab.setOnClickListener(this);


    }

    @Override
    protected void initData() {

    }

    /**
     * 点击事件 监听
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.details_watch_fab:

                MoreBottomDialog dialog = new MoreBottomDialog();
                dialog.show(getSupportFragmentManager());
                dialog.setOnItemClickListener(this);

                break;
            default:
                break;
        }
    }

    /**
     * BottomDialog 点击时间监听
     *
     * @param view
     */
    @Override
    public void onItemClick(View view) {
        switch (view.getId()) {
            case R.id.details_watch_brainstorming:
                Toast.makeText(WatchActivity.this, "kak", Toast.LENGTH_SHORT).show();
                break;
            case R.id.details_watch_check_in:
                break;
            case R.id.details_watch_download:
                break;
            case R.id.details_watch_homework:
                break;
            case R.id.details_watch_question:
                break;
            case R.id.details_watch_vote:
                break;
            default:
                break;
        }

    }
}
