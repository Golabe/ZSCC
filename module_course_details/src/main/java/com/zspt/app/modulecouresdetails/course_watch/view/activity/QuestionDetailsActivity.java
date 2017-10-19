package com.zspt.app.modulecouresdetails.course_watch.view.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zspt.app.library_common.app.AppConstant;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.library_common.widget.CircleImageView;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.adapter.QuestionDetailsAdapter;
import com.zspt.app.modulecouresdetails.course_watch.model.QuestionDetailsModel;

import java.util.ArrayList;

public class QuestionDetailsActivity extends BaseMvpActivity implements SwipeRefreshLayout.OnRefreshListener {
    private Toolbar mToolbar;
    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private QuestionDetailsAdapter mQuestionDetailsAdapter;
    private Button mAnswer;

    @Override
    protected void onFetchData() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_question_details;
    }

    @Override
    protected void initView() {
        initToolbar();
        mRefreshLayout = $(R.id.main_swipe_refresh);
        mAnswer = $(R.id.question_details_answer);
        mRefreshLayout.setOnRefreshListener(this);
//        mRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                mRefreshLayout.setRefreshing(true);
//            }
//        });

        mQuestionDetailsAdapter = new QuestionDetailsAdapter(R.layout.item_question_details_one, new ArrayList<QuestionDetailsModel>());
        mRecyclerView = $(R.id.main_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mQuestionDetailsAdapter.addHeaderView(getHeaderView(1));

        mRecyclerView.setAdapter(mQuestionDetailsAdapter);
        mAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuestionDetailsActivity.this, AnswerActivity.class));
                startActivityForResult(new Intent(QuestionDetailsActivity.this,AnswerActivity.class), AppConstant.REQUEST_CODE_ANSWER);
            }
        });

    }

    private void initToolbar() {
        mToolbar = $(R.id.question_details_toolbar);
        mToolbar.setTitle("详情");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_back_48);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private View getHeaderView(int type) {
        View view = getLayoutInflater().inflate(R.layout.item_question_details_one, (ViewGroup) mRecyclerView.getParent(), false);
        if (type == 1) {
            CircleImageView imageView = view.findViewById(R.id.item_question_details_image);
            imageView.setImageResource(R.mipmap.ic_launcher);
            TextView content = view.findViewById(R.id.item_question_details_content);
            content.setText("哈哈");
            TextView title = view.findViewById(R.id.item_question_details_title);
            title.setText("Title");
        }
        return view;
    }

    @Override
    protected void initData() {

    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case AppConstant.REQUEST_CODE_ANSWER:
                switch (resultCode){

                }

                break;
        }

    }
}
