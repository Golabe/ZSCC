package com.zspt.app.modulelogin.view.fragment;

import com.zspt.app.library_common.base.mvp.IBaseView;
import com.zspt.app.modulelogin.model.SignInResult;

/**
 * Created by yuequan on 2017/10/17.
 */

public interface ISignInView  extends IBaseView{

    void onLoginSuccess(SignInResult data);
    void onLoginError(String message);
    void showProgress();
    void hideProgress();

}
