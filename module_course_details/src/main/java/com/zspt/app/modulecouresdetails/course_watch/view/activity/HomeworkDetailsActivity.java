package com.zspt.app.modulecouresdetails.course_watch.view.activity;


import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.adapter.HomeworkDetailsAdapter;
import com.zspt.app.modulecouresdetails.course_watch.model.HomeworkDetailsModel;
import com.zspt.app.modulecouresdetails.course_watch.presenter.HomeworkDetailsPresenter;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.interfaces.IHomeworkDetailsView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeworkDetailsActivity extends BaseMvpActivity implements IHomeworkDetailsView {
    private RecyclerView mRecyclerView;
    private HomeworkDetailsAdapter mHomeworkDetailsAdapter;
    private List<HomeworkDetailsModel> mData = new ArrayList<>();
    private LinearLayout mErrorLayout;
    private TextView mErrorText;

    private Map<Integer, String> mErrorTopicMap = new HashMap<>();

    @Override
    protected void onFetchData() {
        HomeworkDetailsPresenter presenter = new HomeworkDetailsPresenter(this);
        presenter.getHomeworkDetailsList();
        addPresenter(presenter);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_homework_details;
    }

    @Override
    protected void initView() {
        initToolbar();
        onFetchData();
        mErrorLayout = $(R.id.homework_details_error_layout);
        mErrorText = $(R.id.homework_details_error_text);

        mHomeworkDetailsAdapter = new HomeworkDetailsAdapter(R.layout.item_homework_details, new ArrayList<HomeworkDetailsModel>());
        mRecyclerView = $(R.id.homework_details_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mHomeworkDetailsAdapter);

        mHomeworkDetailsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int i = view.getId();
                if (i == R.id.item_homework_details_a) {
                    judge(position, "A");
                } else if (i == R.id.item_homework_details_b) {
                    judge(position, "B");
                } else if (i == R.id.item_homework_details_c) {
                    judge(position, "C");
                } else if (i == R.id.item_homework_details_d) {
                    judge(position, "D");
                } else {

                }
            }
        });

    }

    public void judge(int position, String tag) {

        if (!mData.get(position).getOk().equals(tag)) {
            mErrorTopicMap.put(position, tag);
        }
    }


    private void initToolbar() {
        Toolbar toolbar = $(R.id.homework_details_toolbar);
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setTitle("答题");
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
        getMenuInflater().inflate(R.menu.menu_homework_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.menu_homework_details_submit) {
            mRecyclerView.setVisibility(View.GONE);
            mErrorLayout.setVisibility(View.VISIBLE);
            for (Map.Entry<Integer, String> map : mErrorTopicMap.entrySet()) {
                mErrorText.append("第" + (1+map.getKey()) + "题：" +"正确答案："+mData.get(map.getKey()).getOk()+ "    你选择的答案：" + map.getValue() + "\n");
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(List<HomeworkDetailsModel> data) {
        if (data.size() == 0) {

        } else {
            mData = data;
            mHomeworkDetailsAdapter.bindNewData(data);
        }
    }
}
