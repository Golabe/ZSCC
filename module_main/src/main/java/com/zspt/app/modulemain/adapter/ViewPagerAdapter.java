package com.zspt.app.modulemain.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yuequan on 2017/10/9.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;
    public ViewPagerAdapter(FragmentManager fm,List<Fragment> fragments,List<String>titles) {
        super(fm);
        this.mFragments=fragments;
        this.mTitles=titles;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
