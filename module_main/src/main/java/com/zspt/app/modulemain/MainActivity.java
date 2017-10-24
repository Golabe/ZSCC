package com.zspt.app.modulemain;



import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;

import com.zspt.app.library_common.base.activity.BaseActivity;
import com.zspt.app.librarybottomtablayout.BottomTabLayout;
import com.zspt.app.librarybottomtablayout.adapter.BottomTabViewPagerAdapter;

import com.zspt.app.modulemain.f_course.view.fragment.CourseFragment;
import com.zspt.app.modulemain.f_hot.view.HotFragment;
import com.zspt.app.modulemain.f_me.view.MeFragment;
import com.zspt.app.modulemain.f_study.view.StudyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private HotFragment mHotFragment;
    private StudyFragment mStudyFragment;
    private CourseFragment mCourseFragment;
    private MeFragment mMeFragment;

    private List<BottomTabLayout.TabItemView>mTabItemViews;
    private List<Fragment>mFragments;



    private BottomTabLayout mBottomTabLayout;
    private ViewPager mViewPager;
    private BottomTabViewPagerAdapter  mBottomTabViewPagerAdapter;

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setSwipeBackEnable(false);
        mBottomTabLayout=$(R.id.navigation);
        mViewPager=$(R.id.main_content);


        initFragments();

    }

    private void initFragments() {
        mTabItemViews=new ArrayList<>();
        mFragments=new ArrayList<>();

        mHotFragment=new HotFragment();
        mStudyFragment=new StudyFragment();
        mCourseFragment=new CourseFragment();
        mMeFragment=new MeFragment();

        mFragments.add(mHotFragment);
        mFragments.add(mCourseFragment);
        mFragments.add(mStudyFragment);
        mFragments.add(mMeFragment);

        mBottomTabViewPagerAdapter=new BottomTabViewPagerAdapter(getSupportFragmentManager(),mFragments);
        mViewPager.setAdapter(mBottomTabViewPagerAdapter);

        mTabItemViews.add(new BottomTabLayout.TabItemView(this, R.drawable.ic_hot_48, R.drawable.ic_hot_checked_48));
        mTabItemViews.add(new BottomTabLayout.TabItemView(this, R.drawable.ic_coures_48, R.drawable.ic_coures_checked_48));
        mTabItemViews.add(new BottomTabLayout.TabItemView(this, R.drawable.ic_study_48, R.drawable.ic_study_checked_48));
        mTabItemViews.add(new BottomTabLayout.TabItemView(this, R.drawable.ic_me_48, R.drawable.ic_me_checked_48));

        mBottomTabLayout.setTabItemViews(mTabItemViews);
        mBottomTabLayout.setUpWithViewPager(mViewPager);
    }

    @Override
    protected void initData() {

    }


}
