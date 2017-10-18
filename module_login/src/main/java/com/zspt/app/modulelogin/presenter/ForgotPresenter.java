package com.zspt.app.modulelogin.presenter;

import android.util.Log;

import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulelogin.api.IForgotApi;
import com.zspt.app.modulelogin.model.ForgotModel;
import com.zspt.app.modulelogin.view.IForgotView;

/**
 * Created by yuequan on 2017/10/17.
 */

public class ForgotPresenter extends BasePresenter<IForgotView> {
    private static final String TAG = "ForgotPresenter";
    public ForgotPresenter(IForgotView mView) {
        super(mView);

    }

    public void onForgot(){
        mSubscription= RxManager.getInstance().doSubscribe(NetManager.getInstance().create(IForgotApi.class).onForgot()
                , new RxSubscriber<ForgotModel>(false) {
                    @Override
                    protected void _onNext(ForgotModel data) {
                        Log.d(TAG, "_onNext: "+data.getMessage());
                    }

                    @Override
                    protected void _onError(Throwable e) {
                        Log.d(TAG, "_onError: "+e.toString());
                    }
                });
    }
}
