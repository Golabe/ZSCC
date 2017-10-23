package com.zspt.app.modulecouresdetails.api;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.modulecouresdetails.course_watch.model.QuestionResult;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yuequan on 2017/10/23.
 */

public interface IQuestionSubmitApi {
    @FormUrlEncoded
    @POST("")
    Observable<HttpResult<QuestionResult>>getQuesionResultData(@FieldMap Map<String,String>map);
}
