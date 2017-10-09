package com.zspt.app.modulemain;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.zspt.app.library_common.base.activity.BaseActivity;
import com.zspt.app.librarybottomtablayout.BottomTabLayout;
import com.zspt.app.modulemain.f_download.DownloadFragment;
import com.zspt.app.modulemain.f_home.HomeFragment;
import com.zspt.app.modulemain.f_me.MeFragment;
import com.zspt.app.modulemain.f_study.StudyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements BottomTabLayout.OnTabItemSelectListener {

    private HomeFragment mHomeFragment;
    private StudyFragment mStudyFragment;
    private DownloadFragment mDownloadFragment;
    private MeFragment mMeFragment;

    private List<BottomTabLayout.TabItemView>mTabItemViews;
    private List<Fragment>mFragments;
    private static int lastShowFragment = 0;


    private BottomTabLayout mBottomTabLayout;
    private FrameLayout mFrameLayout;

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mFrameLayout=$(R.id.main_content);
        mBottomTabLayout=$(R.id.navigation);

        mBottomTabLayout.setOnTabItemSelectListener(this);

        initFragments();


    }

    private void initFragments() {
        mTabItemViews=new ArrayList<>();
        mFragments=new ArrayList<>();

        mHomeFragment=new HomeFragment();
        mStudyFragment=new StudyFragment();
        mDownloadFragment=new DownloadFragment();
        mMeFragment=new MeFragment();

        mFragments.add(mHomeFragment);
        mFragments.add(mStudyFragment);
        mFragments.add(mDownloadFragment);
        mFragments.add(mMeFragment);
        mTabItemViews.add(new BottomTabLayout.TabItemView(this, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round));
        mTabItemViews.add(new BottomTabLayout.TabItemView(this, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round));
        mTabItemViews.add(new BottomTabLayout.TabItemView(this, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round));
        mTabItemViews.add(new BottomTabLayout.TabItemView(this, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round));

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_content, mHomeFragment)
                .show(mHomeFragment)
                .commit();

        mBottomTabLayout.setTabItemViews(mTabItemViews);
    }

    @Override
    protected void initData() {

    }


    /**
     * Fragment 切换
     * @param position
     */

    @Override
    public void onTabItemSelect(int position) {

        switch (position){
            case 0:
                if (lastShowFragment != 0) {
                    switchFragment(lastShowFragment, 0);
                    lastShowFragment = 0;
                }
                break;
            case 1:
                if (lastShowFragment != 1) {
                    switchFragment(lastShowFragment, 1);
                    lastShowFragment = 1;
                }
                break;
            case 2:
                if (lastShowFragment != 2) {
                    switchFragment(lastShowFragment, 2);
                    lastShowFragment = 2;
                }
                break;
            case 3:
                if (lastShowFragment != 3) {
                    switchFragment(lastShowFragment, 3);
                    lastShowFragment = 3;
                }
                break;

            default:
                break;
        }
    }
    /**
     * 切换Fragment
     *
     * @param lastIndex 上个显示Fragment的索引
     * @param index     需要显示的Fragment的索引
     */
    public void switchFragment(int lastIndex, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(mFragments.get(lastIndex));
        if (!mFragments.get(index).isAdded()) {
            transaction.add(R.id.main_content, mFragments.get(index));
        }
        transaction.show(mFragments.get(index)).commitAllowingStateLoss();
    }

}
