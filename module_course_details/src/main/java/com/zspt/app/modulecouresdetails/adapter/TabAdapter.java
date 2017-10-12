package com.zspt.app.modulecouresdetails.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yuequan on 2017/10/11.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<String>mTitles;
    private List<Fragment>mFragments;

    public TabAdapter(FragmentManager fm,List<Fragment>fragments,List<String>titles) {
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
