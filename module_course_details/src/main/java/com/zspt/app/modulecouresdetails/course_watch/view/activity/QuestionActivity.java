package com.zspt.app.modulecouresdetails.course_watch.view.activity;

import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.library_common.util.hint.ToastUtil;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.presenter.QuestionActivityPresenter;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.interfaces.IQuestionActivityView;


public class QuestionActivity extends BaseMvpActivity implements IQuestionActivityView {
    private Toolbar mToolbar;
    private QuestionActivityPresenter mQuestionActivityPresenter;
    private EditText mTitle, mContent;

    @Override
    protected void onFetchData() {
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_question;
    }

    @Override
    protected void initView() {
        mQuestionActivityPresenter = new QuestionActivityPresenter(this);
        initToolbar();
        mTitle = $(R.id.question_title);
        mContent = $(R.id.question_content);
    }

    private void initToolbar() {
        mToolbar = $(R.id.question_toolbar);
        mToolbar.setTitle("提问");
        mToolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_back_48);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
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
        getMenuInflater().inflate(R.menu.menu_question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();

        if (i == R.id.menu_question_release) {
            int contentLength = mContent.length();
            int titleLength = mTitle.length();
            if (titleLength == 0 || contentLength == 0) {
                ToastUtil.showShortToast("发送内容不为空");
            } else if (contentLength < 5 || titleLength < 5) {
                ToastUtil.showShortToast("发送内容不能少于5个字");
            } else {

            }
        }
        return super.onOptionsItemSelected(item);
    }
}
