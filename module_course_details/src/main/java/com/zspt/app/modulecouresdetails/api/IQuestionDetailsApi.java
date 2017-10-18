package com.zspt.app.modulecouresdetails.api;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.modulecouresdetails.course_watch.model.QuestionDetailsModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yuequan on 2017/10/18.
 */

public interface IQuestionDetailsApi {
    @GET("")
    Observable<HttpResult<List<QuestionDetailsModel>>>getQuestionDetailsData();
}
