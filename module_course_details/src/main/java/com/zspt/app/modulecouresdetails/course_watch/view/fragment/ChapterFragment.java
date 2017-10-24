package com.zspt.app.modulecouresdetails.course_watch.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zspt.app.library_common.base.fragment.BaseMvpFragment;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.adapter.ChapterAdapter;
import com.zspt.app.modulecouresdetails.course_watch.model.ChapterLevel0Item;
import com.zspt.app.modulecouresdetails.course_watch.model.ChapterLevel1Item;
import com.zspt.app.modulecouresdetails.course_watch.presenter.ChapterPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/11.
 */

public class ChapterFragment extends BaseMvpFragment implements IChapterView ,SwipeRefreshLayout.OnRefreshListener{
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private ChapterAdapter mChapterAdapter;
    private List<MultiItemEntity>mData;

    @Override
    protected void fetchData() {
        ChapterPresenter presenter = new ChapterPresenter(this);
        addPresenter(presenter);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_chapter;
    }

    @Override
    protected void initView() {
        mRefreshLayout=$(R.id.main_swipe_refresh);
        mRefreshLayout.setOnRefreshListener(this);

        mRecyclerView=$(R.id.main_recycler);
        mData=getData();
        mChapterAdapter=new ChapterAdapter(mData);
        mRecyclerView.setAdapter(mChapterAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false));
        mChapterAdapter.expandAll();

    }
    private ArrayList<MultiItemEntity> getData(){

        ArrayList<MultiItemEntity>list=new ArrayList<>();
        for (int i=0;i<10;i++){
            ChapterLevel0Item lv0=new ChapterLevel0Item("第"+i+"章");
            for (int j=0;j<5;j++){

                lv0.addSubItem(new ChapterLevel1Item(i+"-"+j,j+":"+j) );
            }
            list.add(lv0);
        }
        return list;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onRefresh() {
        mRefreshLayout.setRefreshing(false);
    }
}
