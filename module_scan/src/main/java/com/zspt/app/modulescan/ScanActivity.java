package com.zspt.app.modulescan;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.zspt.app.library_common.app.AppConstant;
import com.zspt.app.library_common.base.activity.BaseActivity;
import com.zspt.app.library_common.base.activity.BaseMvpActivity;

@Route(path = AppConstant.MODULE_SCAN)
public class ScanActivity extends BaseActivity {
    public static boolean isOpen = false;

    private CaptureFragment mCaptureFragment;
    private Toolbar mToolbar;
    private ImageView mLamp;
    @Override
    protected int bindLayoutId() {
        return R.layout.activity_scan;
    }

    @Override
    protected void initView() {
        ZXingLibrary.initDisplayOpinion(this);

        mToolbar = $(R.id.scan_toolbar);
        mLamp=$(R.id.lamp);
        initToolbar();

        initScanView();


    }

    private void initToolbar() {
        mToolbar.setTitle("二维码/条形码");
        mToolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_back_48);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * 初始化定制界面
     */
    private void initScanView() {
        mCaptureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(mCaptureFragment, R.layout.my_camera);
        mCaptureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_my_container, mCaptureFragment)
                .commit();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear1);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen) {
                    CodeUtils.isLightEnable(true);
                    isOpen = true;
                    mLamp.setImageResource(R.drawable.ic_lamp_on);
                } else {
                    CodeUtils.isLightEnable(false);
                    isOpen = false;
                    mLamp.setImageResource(R.drawable.ic_lamp_off);
                }
            }
        });
    }


    @Override
    protected void initData() {

    }

    /**
     * 二维码解析回调函数
     */
    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            if (result == null) {
                return;
            }
            ARouter.getInstance().build(AppConstant.MODULE_COURSE_DETAILS)
                    .withInt("tag",200)
                    .withString("id",result)
                    .navigation();
            finish();
        }

        @Override
        public void onAnalyzeFailed() {

            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            ScanActivity.this.setResult(RESULT_OK, resultIntent);
            Toast.makeText(ScanActivity.this, "失败", Toast.LENGTH_SHORT).show();
            // ScanActivity.this.finish();
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
