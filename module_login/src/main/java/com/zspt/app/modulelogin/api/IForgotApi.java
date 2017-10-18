package com.zspt.app.modulelogin.api;

import com.zspt.app.modulelogin.model.ForgotModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yuequan on 2017/10/17.
 */

public interface IForgotApi {
    @GET("v1/cat")
    Observable<ForgotModel>onForgot();
}
