package com.zspt.app.modulemain.launcher.presenter;

import android.util.Log;

import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;

import com.zspt.app.modulemain.api.ILauncherApi;
import com.zspt.app.modulemain.launcher.model.LauncherModel;
import com.zspt.app.modulemain.launcher.view.ILauncherView;



/**
 * Created by yuequan on 2017/10/16.
 */

public class LauncherPresenter extends BasePresenter<ILauncherView>  {
    private static final String TAG = "LauncherPresenter";

    public LauncherPresenter(ILauncherView mView) {
        super(mView);
    }

    public void getData() {

        mSubscription = RxManager.getInstance().
                doSubscribe(NetManager.getInstance().create(ILauncherApi.class).getData("launcher/index.php"),
                        new RxSubscriber<LauncherModel>(false) {
                            @Override
                            protected void _onNext(LauncherModel data) {
                                Log.d(TAG, "_onNext: " + data.getMessage());
                                if (data == null) {
                                    return;
                                } else {
                                    if (data.getCode() == 200) {
                                        mView.onSuccess(data);
                                    }
                                }
                            }

                            @Override
                            protected void _onError(Throwable e) {
                                Log.d(TAG, "_onError: " + e.toString());
                            }
                        });
    }



}
