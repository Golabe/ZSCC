package com.zspt.app.modulecouresdetails.course_watch.view.activity;


import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.util.hint.ToastUtil;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.adapter.MyTextWatcher;
import com.zspt.app.modulecouresdetails.course_watch.model.ReleaseCommentModel;
import com.zspt.app.modulecouresdetails.course_watch.presenter.ReleaseCommentPresenter;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.interfaces.IReleaseCommentView;

public class ReleaseCommentActivity extends BaseMvpActivity implements IReleaseCommentView {
    private EditText mEditText;
    private TextView mCount;
    private ReleaseCommentPresenter mPresenter;

    @Override
    protected void onFetchData() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_release_comment;
    }

    @Override
    protected void initView() {
        mPresenter = new ReleaseCommentPresenter(this);
        initToolbar();
        mEditText = $(R.id.release_comment_input_comment);
        mCount = $(R.id.release_comment_count);

        mEditText.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                mCount.setText(mEditText.length() + "/200");
            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = $(R.id.release_comment_toolbar);
        toolbar.setTitle("写评论");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_release_comment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.menu_release_comment_release) {
            int length = mEditText.length();
            if (length == 0) {
                ToastUtil.showShortToast("发送内容不为空");
            } else if (length < 5) {
                ToastUtil.showShortToast("发送内容不能少于5个字");
            } else {
                mPresenter.releaseComment(new ReleaseCommentModel());
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(HttpResult result) {

    }
}
