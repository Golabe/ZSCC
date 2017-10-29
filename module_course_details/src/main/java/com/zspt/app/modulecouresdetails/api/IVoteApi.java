package com.zspt.app.modulecouresdetails.api;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.modulecouresdetails.course_watch.model.VoteModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yuequan on 2017/10/25.
 */

public interface IVoteApi {
    @GET("vote/vote.php")
    Observable<HttpResult<List<VoteModel>>>getVoteData();
}
