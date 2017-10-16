package com.zspt.app.library_common.util.timer;

import android.os.CountDownTimer;

/**
 * Created by yuequan on 2017/10/16.
 */

public class DownCountTimer extends CountDownTimer {
    private ICountTimerListener mICountTimerListener = null;

    public DownCountTimer(ICountTimerListener listener,int millisInFuture, int countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.mICountTimerListener=listener;
    }

    @Override
    public void onTick(long l) {
        if (mICountTimerListener != null) {
            mICountTimerListener.onTick(l);
        }

    }

    @Override
    public void onFinish() {
        if (mICountTimerListener != null) {
            mICountTimerListener.onFinish();
        }
    }
}
