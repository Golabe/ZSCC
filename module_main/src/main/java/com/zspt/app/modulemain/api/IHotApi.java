package com.zspt.app.modulemain.api;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.modulemain.f_hot.model.HotModel;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by yuequan on 2017/10/12.
 */

public interface IHotApi {
    String BASE_URL = "http://127.0.0.1/api/hot.php/";

    @GET
    Observable<HttpResult<List<HotModel>>> getHotData(@Url String url);
}
