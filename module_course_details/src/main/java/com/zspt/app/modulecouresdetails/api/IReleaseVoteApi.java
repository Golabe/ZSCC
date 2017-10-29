package com.zspt.app.modulecouresdetails.api;

import com.zspt.app.library_common.base.model.HttpResult;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yuequan on 2017/10/25.
 */

public interface IReleaseVoteApi {
    @FormUrlEncoded
    @POST("")
    Observable<HttpResult>releaseVote(@FieldMap Map<String,String>map);
}
