package com.zspt.app.library_common.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by yuequan on 2017/10/8.
 */

public class BaseApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();

    }

    public static Context getContext(){
        return mContext;
    }
}
