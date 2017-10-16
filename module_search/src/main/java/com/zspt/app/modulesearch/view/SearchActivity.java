package com.zspt.app.modulesearch.view;


import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zspt.app.library_common.app.AppConstant;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulesearch.R;
import com.zspt.app.modulesearch.presenter.SearchPresenter;

@Route(path = AppConstant.MODULE_SEARCH)
public class SearchActivity extends BaseMvpActivity implements ISearchView{
    private SearchView mSearchView;
    private Toolbar mToolbar;

    @Override
    protected void onFetchData() {
        SearchPresenter presenter=new SearchPresenter(this);
        addPresenter(presenter);

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {

        mToolbar = $(R.id.search_toolbar);
        mSearchView = $(R.id.search_search_view);
        initToolbar();
        initSearchView();

    }

    private void initToolbar() {
        mToolbar.setNavigationIcon(R.drawable.ic_back_48);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setSubmitButtonEnabled(true);
        TextView textView = mSearchView
                .findViewById(android.support.v7.appcompat.R.id.search_src_text);
        textView.setTextSize(15f);
        textView.setHint("搜索课程");

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onError() {

    }
}
