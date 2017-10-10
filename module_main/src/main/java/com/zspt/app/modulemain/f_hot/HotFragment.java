package com.zspt.app.modulemain.f_hot;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.youth.banner.Banner;
import com.zspt.app.library_common.base.fragment.BaseMvpFragment;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.f_hot.presenter.HotPresenter;
import com.zspt.app.modulemain.f_hot.view.IHotView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/10.
 */

public class HotFragment extends BaseMvpFragment implements IHotView {

    private HotPresenter mHotPresenter;

    private List<String> mImageUrl = new ArrayList<>();


    private Banner mBanner;
    private Toolbar mToolbar;

    @Override
    protected void fetchData() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        setHasOptionsMenu(true);

        mHotPresenter=new HotPresenter(this);

        mBanner = $(R.id.hot_banner);
        mToolbar = $(R.id.hot_toolbar);

        initToolbar();

        mHotPresenter.onBanner(mBanner, mImageUrl);


    }

    /**
     * 初始化Toolbar
     */
    private void initToolbar() {
        mToolbar.setTitleTextColor(Color.BLACK);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
    }


    @Override
    protected void initData() {

    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_hot, menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if (i == R.id.main_menu_scan) {

        } else if (i == R.id.main_menu_search) {


        } else {

        }
        return true;
    }

    @Override
    public void onError() {

    }


}
