package com.zspt.app.modulemain.api;

import com.zspt.app.modulemain.launcher.model.LauncherModel;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by yuequan on 2017/10/16.
 */

public interface ILauncherApi {
    @GET
    Observable<LauncherModel>getData(@Url String url);
}
