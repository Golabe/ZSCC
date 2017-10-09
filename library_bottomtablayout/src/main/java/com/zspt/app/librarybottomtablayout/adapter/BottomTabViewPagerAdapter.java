package com.zspt.app.librarybottomtablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yuequan on 2017/9/24.
 */

public class BottomTabViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public BottomTabViewPagerAdapter(FragmentManager fm, List<Fragment>fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
