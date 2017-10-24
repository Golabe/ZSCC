package com.zspt.app.modulemain.api;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.modulemain.a_guide.model.GuideBannerMode;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yuequan on 2017/10/24.
 */

public interface IGuideBannerApi {
    @GET("guide/index.php")
    Observable<HttpResult<List<GuideBannerMode>>>getGuideBannerData();
}
