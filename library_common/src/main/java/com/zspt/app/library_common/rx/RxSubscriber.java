package com.zspt.app.library_common.rx;

import android.content.Context;
import android.util.Log;

import com.zspt.app.library_common.app.BaseApplication;

import java.io.IOException;

import rx.Subscriber;

/**
 * Created by yuequan on 2017/10/9.
 */

public abstract class RxSubscriber<T> extends Subscriber<T> {
    private static final String TAG = "RxSubscriber";
    private Context mContext;

    private boolean mIsLoading;//是否显示加载

    public RxSubscriber(boolean isLoading) {
        this.mContext = BaseApplication.getContext();
        this.mIsLoading = isLoading;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: "+e.toString());
        //处理请求异常
        if (e instanceof IOException) {
            //网络连接异常
        } else {

        }

        _onError(e);
        onHideLoading();
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onStart() {
        super.onStart();
        onShowLoading();
    }

    /**
     * 显示loading
     */
    private void onShowLoading() {
        if (mIsLoading) {

        }
    }


    /**
     * 隐藏loading
     */
    private void onHideLoading() {

    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(Throwable e);
}
