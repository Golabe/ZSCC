package com.zspt.app.library_common.util.hint;

import android.widget.Toast;

import com.zspt.app.library_common.app.BaseApplication;

/**
 * Created by yuequan on 2017/10/25.
 */

public final class ToastUtil {

    public static final void showShortToast(String title){
        Toast.makeText(BaseApplication.getContext(),title,Toast.LENGTH_SHORT).show();
    }
    public static final void showLongToast(String title){
        Toast.makeText(BaseApplication.getContext(),title,Toast.LENGTH_LONG).show();
    }

}
