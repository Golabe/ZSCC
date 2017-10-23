package com.zspt.app.modulelogin.presenter;

import android.util.Log;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulelogin.api.ISignInApi;
import com.zspt.app.modulelogin.model.SignInResult;
import com.zspt.app.modulelogin.model.UserModel;
import com.zspt.app.modulelogin.view.fragment.ISignInView;

/**
 * Created by yuequan on 2017/10/17.
 */

public class SignInPresenter extends BasePresenter<ISignInView> {
    private static final String TAG = "SignInPresenter";

    public SignInPresenter(ISignInView mView) {
        super(mView);
    }

    public void onSignIn(UserModel user) {
        mView.showProgress();

        mSubscription=RxManager.getInstance().doSubscribe(NetManager.getInstance().create(ISignInApi.class).onLogin(user.getAccount(), user.getPassword())
                , new RxSubscriber<HttpResult<SignInResult>>(false) {
                    @Override
                    protected void _onNext(HttpResult<SignInResult> data) {
                        Log.d(TAG, "_onNext: "+data.getData().getName());
                        if (data!=null){
                            mView.hideProgress();
                            if (data.getStatus()==200){
                                mView.onLoginSuccess(data.getData());
                                Log.d(TAG, "_onNext: "+data.getData().getName());
                            }
                            else if (data.getStatus()==1000){
                                mView.onLoginError("手机号或密码错误");
                            }
                        }
                    }

                    @Override
                    protected void _onError(Throwable e) {
                        mView.onError();
                        Log.d(TAG, "_onError: "+e.toString());
                    }
                });
    }
}
