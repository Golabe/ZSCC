package com.zspt.app.modulecouresdetails.api;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.modulecouresdetails.course_watch.model.QuestionLevel0;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yuequan on 2017/10/18.
 */

public interface IQuestionLevel0Api {
    @GET("question/index.php")
    Observable<HttpResult<List<QuestionLevel0>>>getQuestionData();
}
