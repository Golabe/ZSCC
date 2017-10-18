package com.zspt.app.modulelogin.view.fragment;


import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.utils.TextUtils;
import com.zspt.app.library_common.base.fragment.BaseMvpFragment;
import com.zspt.app.modulelogin.R;
import com.zspt.app.modulelogin.callback.MyTextWatcher;
import com.zspt.app.modulelogin.model.SignInResult;
import com.zspt.app.modulelogin.model.UserModel;
import com.zspt.app.modulelogin.presenter.SignInPresenter;
import com.zspt.app.modulelogin.view.ForgotActivity;

/**
 * Created by yuequan on 2017/10/16.
 */

public class SignInFragment extends BaseMvpFragment implements ISignInView {

    private TextInputLayout mAccountLayout;
    private TextInputLayout mPasswordLayout;
    private TextInputEditText mAccount;
    private TextInputEditText mPassword;
    private Button mLogin;
    private ProgressBar mLoginProgress;
    private SignInPresenter mSignInPresenter;

    private TextView mForgot;

    private boolean isAccountFlag = false, isPasswordFlag = false;

    @Override
    protected void fetchData() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_sign_in;
    }

    @Override
    protected void initView() {
        mSignInPresenter = new SignInPresenter(this);
        mAccountLayout = $(R.id.sign_in_input_account_layout);
        mPasswordLayout = $(R.id.sign_in_input_password_layout);
        mAccount = $(R.id.sign_in_input_account);
        mPassword = $(R.id.sign_in_input_password);
        mLogin = $(R.id.sign_in_login);
        mLoginProgress = $(R.id.sign_in_progress);
        mForgot=$(R.id.sign_in_forgot);

        mAccount.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                if (TextUtils.isEmpty(mAccount.getText().toString())) {
                    mAccountLayout.setError("手机号不为空");
                    isAccountFlag=false;
                } else if (mAccount.length() != 11) {
                    mAccountLayout.setError("输入11位手机号");
                    isAccountFlag=false;
                } else {
                    mAccountLayout.setError("");
                    isAccountFlag = true;
                }
            }
        });

        mPassword.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                if (TextUtils.isEmpty(mPassword.getText().toString())) {
                    mPasswordLayout.setError("密码不为空");
                    isPasswordFlag = false;
                } else if (mPassword.length() < 8) {
                    mPasswordLayout.setError("密码长度小于8");
                    isPasswordFlag = false;
                } else {
                    mPasswordLayout.setError("");
                    isPasswordFlag = true;
                }
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAccountFlag && isPasswordFlag) {
                    mSignInPresenter.onSignIn(new UserModel(mAccount.getText().toString(), mPassword.getText().toString()));
                }

            }
        });

        mForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ForgotActivity.class));

            }
        });
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onError() {

    }


    @Override
    public void onLoginSuccess(SignInResult data) {
        Toast.makeText(getContext(),data.getName(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showProgress() {
        mLogin.setVisibility(View.GONE);
        mLoginProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mLogin.setVisibility(View.VISIBLE);
        mLoginProgress.setVisibility(View.GONE);
    }
}
