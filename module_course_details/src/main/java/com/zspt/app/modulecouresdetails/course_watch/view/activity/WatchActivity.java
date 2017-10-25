package com.zspt.app.modulecouresdetails.course_watch.view.activity;



import android.content.Intent;
import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.zspt.app.library_common.app.AppConstant;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.adapter.TabAdapter;
import com.zspt.app.modulecouresdetails.course_watch.presenter.WatchPresenter;
import com.zspt.app.modulecouresdetails.course_watch.view.fragment.ChapterFragment;
import com.zspt.app.modulecouresdetails.course_watch.view.fragment.CommentFragment;
import com.zspt.app.modulecouresdetails.course_watch.view.fragment.QuestionFragment;
import com.zspt.app.modulecouresdetails.util.MoreBottomDialog;

import java.util.ArrayList;
import java.util.List;

@Route(path = AppConstant.MODULE_WATCH)
public class WatchActivity extends BaseMvpActivity implements IWatchView,View.OnClickListener, MoreBottomDialog.OnItemClickListener {

    private FloatingActionButton mFab;
    private IjkVideoView mIjkVideoView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    private List<String>mTabTitles;
    private List<Fragment>mTabFragments;

    private static final String VIDEO_URL = "http://flv2.bn.netease.com/videolib3/1611/28/GbgsL3639/SD/movie_index.m3u8";
    private static final String VIDEO_HD_URL = "http://flv2.bn.netease.com/videolib3/1611/28/GbgsL3639/HD/movie_index.m3u8";
    private static final String IMAGE_URL = "http://vimg2.ws.126.net/image/snapshot/2016/11/I/M/VC62HMUIM.jpg";
    /**
     * 绑定Presenter
     */
    @Override
    protected void onFetchData() {
        WatchPresenter mWatchPresenter=new WatchPresenter(this);
        addPresenter(mWatchPresenter);

    }


    @Override
    protected int bindLayoutId() {
        return R.layout.activity_watch;
    }

    @Override
    protected void initView() {

        mFab = $(R.id.details_watch_fab);
        mTabLayout=$(R.id.details_watch_tab);
        mIjkVideoView=$(R.id.details_watch_player);
        mViewPager=$(R.id.details_watch_view_pager);

        initTabLayout();
        initPlayer();
        mFab.setOnClickListener(this);

    }

    private void initTabLayout() {
        mTabTitles=new ArrayList<>();
        mTabFragments=new ArrayList<>();

        mTabTitles.add("章节");
        mTabTitles.add("评论");
        mTabTitles.add("问答");

        mTabFragments.add(new ChapterFragment());
        mTabFragments.add(new CommentFragment());
        mTabFragments.add(new QuestionFragment());

        TabAdapter adapter=new TabAdapter(getSupportFragmentManager(),mTabFragments,mTabTitles);

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);



    }

    private void initPlayer() {

        StandardVideoController controller = new StandardVideoController(this);
        mIjkVideoView
                .autoRotate() //启用重力感应自动进入/推出全屏功能
                //.enableCache() //启用边播边缓存功能
                .useSurfaceView() //启用SurfaceView显示视频，不调用默认使用TextureView
               .useAndroidMediaPlayer() //启动AndroidMediaPlayer，不调用此方法默认使用IjkPlayer
                .setUrl(VIDEO_URL) //设置视频地址
                .setTitle("网易公开课-如何掌控你的自由时间") //设置视频标题
                .setVideoController(controller) //设置控制器，如需定制可继承BaseVideoController
                .start(); //开始播放，不调用则不自动播放
    }

    @Override
    protected void initData() {

    }

    /**
     * 点击事件 监听
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.details_watch_fab) {
            MoreBottomDialog dialog = new MoreBottomDialog();
            dialog.show(getSupportFragmentManager());
            dialog.setOnItemClickListener(this);


        } else {
        }
    }

    /**
     * BottomDialog 点击时间监听
     *
     * @param view
     */
    @Override
    public void onItemClick(View view) {
        int i = view.getId();
        if (i == R.id.details_watch_brainstorming) {
            Toast.makeText(WatchActivity.this, "kak", Toast.LENGTH_SHORT).show();

        } else if (i == R.id.details_watch_comment) {
            startActivity(new Intent(WatchActivity.this,ReleaseCommentActivity.class));
        } else if (i == R.id.details_watch_download) {
        } else if (i == R.id.details_watch_homework) {
            startActivity(new Intent(WatchActivity.this,HomeworkActivity.class));
        } else if (i == R.id.details_watch_question) {
            startActivity(new Intent(WatchActivity.this, QuestionActivity.class));
        } else if (i == R.id.details_watch_vote) {
            startActivity(new Intent(WatchActivity.this,VoteActivity.class));
        } else {
        }

    }

    @Override
    public void onError() {

    }
    @Override
    protected void onPause() {
        super.onPause();
        mIjkVideoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIjkVideoView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIjkVideoView.release();
    }


    @Override
    public void onBackPressed() {
        if (!mIjkVideoView.onBackPressed()) {
            super.onBackPressed();
        }
    }

}
