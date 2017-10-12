package com.zspt.app.library_common.base.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;

import com.zspt.app.libraryswipebacklayout.SwipeBackLayout;
import com.zspt.app.libraryswipebacklayout.app.SwipeBackActivity;


/**
 * Created by yuequan on 2017/10/8.
 */

public abstract class BaseActivity extends SwipeBackActivity {

private SwipeBackLayout mSwipeBackActivity;
    protected Context mContext;

    /**
     * 绑定布局id
     * @return
     */
    protected abstract int bindLayoutId();

    /**
     * 初始化相关控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(bindLayoutId());
        mContext = this;

        mSwipeBackActivity=getSwipeBackLayout();
        mSwipeBackActivity.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明状态栏
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);


        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4 全透明状态栏
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        initView();
        initData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public <T extends View> T $(int id) {
        return (T) findViewById(id);
    }
}
