package com.zspt.app.modulecouresdetails.course_watch.view.activity;

import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.model.QuestionLevel0;
import com.zspt.app.modulecouresdetails.course_watch.presenter.QuestionPresenter;
import com.zspt.app.modulecouresdetails.course_watch.view.fragment.IQuestionView;

import java.util.List;

public class QuestionActivity extends BaseMvpActivity implements IQuestionView {

    @Override
    protected void onFetchData() {
        QuestionPresenter mQuestionPresenter=new QuestionPresenter(this);
        addPresenter(mQuestionPresenter);
    }


    @Override
    protected int bindLayoutId() {
        return R.layout.activity_question;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(List<QuestionLevel0> data) {

    }
}
