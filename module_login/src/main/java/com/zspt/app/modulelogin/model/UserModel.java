package com.zspt.app.modulelogin.model;

/**
 * Created by yuequan on 2017/10/17.
 */

public class UserModel {
    private String account;
    private String password;

    public UserModel(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
