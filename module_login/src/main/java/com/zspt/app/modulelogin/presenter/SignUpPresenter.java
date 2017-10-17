package com.zspt.app.modulelogin.presenter;

import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.modulelogin.model.UserModel;
import com.zspt.app.modulelogin.view.fragment.ISignUpView;

/**
 * Created by yuequan on 2017/10/17.
 */

public class SignUpPresenter extends BasePresenter<ISignUpView> {


    public SignUpPresenter(ISignUpView mView) {
        super(mView);
    }

    public void onRegister(UserModel user){

    }

}
