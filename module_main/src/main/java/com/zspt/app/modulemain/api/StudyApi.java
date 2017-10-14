package com.zspt.app.modulemain.api;

import com.zspt.app.modulemain.f_study.model.StudyHistoryModel;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by yuequan on 2017/10/13.
 */

public interface StudyApi {

    @GET
    Observable<List<StudyHistoryModel>> getStudyData(@Url String url);
}
