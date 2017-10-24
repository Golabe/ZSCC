package com.zspt.app.modulecouresdetails.api;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.modulecouresdetails.course_watch.model.HomeworkModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yuequan on 2017/10/23.
 */

public interface IHomeworkApi {
    @GET("homework/index.php")
    Observable<HttpResult<List<HomeworkModel>>> getHomeworkData();
}
