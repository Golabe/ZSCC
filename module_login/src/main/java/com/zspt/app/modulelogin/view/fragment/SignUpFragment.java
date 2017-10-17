package com.zspt.app.modulelogin.view.fragment;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.utils.TextUtils;
import com.zspt.app.library_common.base.fragment.BaseMvpFragment;
import com.zspt.app.modulelogin.R;
import com.zspt.app.modulelogin.callback.MyTextWatcher;
import com.zspt.app.modulelogin.model.UserModel;
import com.zspt.app.modulelogin.presenter.SignUpPresenter;

/**
 * Created by yuequan on 2017/10/16.
 */

public class SignUpFragment extends BaseMvpFragment implements ISignUpView {

    private SignUpPresenter mSignUpPresenter;
    private Button mRegister;
    private ProgressBar mProgressBar;

    private TextInputLayout mAccountLayout, mPasswordLayout, mAgainPasswordLayout;
    private TextInputEditText mAccount, mPassword, mAgainPassword;
    private boolean isAccountFlag = false, isPasswordFlag = false, isAgainPassword = false;

    @Override
    protected void fetchData() {
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_sign_up;
    }

    @Override
    protected void initView() {
        mSignUpPresenter = new SignUpPresenter(this);
        mRegister = $(R.id.sign_up_login);
        mProgressBar = $(R.id.sign_up_progress);

        mAccountLayout = $(R.id.sign_up_input_account_layout);
        mPasswordLayout = $(R.id.sign_up_input_password_layout);
        mAgainPasswordLayout = $(R.id.sign_up_input_again_password_layout);

        mAccount = $(R.id.sign_up_input_account);
        mPassword = $(R.id.sign_up_input_password);
        mAgainPassword = $(R.id.sign_up_input_again_password);

        mAccount.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);

                if (TextUtils.isEmpty(mAccount.getText().toString())) {
                    mAccountLayout.setError("手机号不为空");
                    isAccountFlag = false;
                } else if (mAccount.length() != 11) {
                    mAccountLayout.setError("输入11位手机号");
                    isAccountFlag = false;
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

        mAgainPassword.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                if (TextUtils.isEmpty(mAgainPassword.getText().toString())) {
                    mAgainPasswordLayout.setError("密码不为空");
                    isAgainPassword = false;
                } else if (!mPassword.getText().toString().equals(mAgainPassword.getText().toString())) {
                    mAgainPasswordLayout.setError("两次密码不相同");
                    isAgainPassword = false;
                } else {
                    mAgainPasswordLayout.setError("");
                    isAgainPassword = true;
                }
            }
        });


        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAccountFlag && isPasswordFlag && isAgainPassword) {
                    mSignUpPresenter.onRegister(new UserModel(mAccount.getText().toString(), mPassword.getText().toString()));
                }
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
    public void showProgress() {
        mRegister.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mRegister.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }
}
