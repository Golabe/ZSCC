package com.zspt.app.library_common.util.preference;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.zspt.app.library_common.app.BaseApplication;

/**
 * Created by yuequan on 2017/10/24.
 */

public final class PreferenceUtil {
    private static final SharedPreferences INSTANCE= PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    private static final String APP_PREFERENCES_KEY="zscc";

    private static SharedPreferences getInstance(){
        return INSTANCE;
    }

    public static void setAppPreferences(String val){
        getInstance()
                .edit()
                .putString(APP_PREFERENCES_KEY,val)
                .apply();
    }

    public static String getAppPreferences(){
        return getInstance().getString(APP_PREFERENCES_KEY,null);
    }

    public static void removeAppPreferences(){
        getInstance()
                .edit()
                .remove(APP_PREFERENCES_KEY)
                .apply();
    }
    public static void setAppFlag(String key,boolean flag){
        getInstance()
                .edit()
                .putBoolean(key,flag)
                .apply();
    }
    public static boolean getAppFlag(String key){
        return getInstance()
                .getBoolean(key,false);
    }

    public static void addCustomAppPreferences(String key, String val) {
        getInstance()
                .edit()
                .putString(key, val)
                .apply();
    }

    public static String getCustomAppPreferences(String key) {
        return getInstance().getString(key, "");
    }
}
