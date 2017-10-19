package com.zspt.app.modulemain.api;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.modulemain.f_hot.model.BannerModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;


/**
 * Created by yuequan on 2017/10/19.
 */

public interface IBannerApi {
    @GET("v1/carousel")
    Observable<HttpResult<List<BannerModel>>> getBanner();
}
