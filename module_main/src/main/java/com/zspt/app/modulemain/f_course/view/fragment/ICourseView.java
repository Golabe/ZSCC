package com.zspt.app.modulemain.f_course.view.fragment;

import com.zspt.app.library_common.base.mvp.IBaseView;
import com.zspt.app.modulemain.f_course.model.CourseHeaderModel;
import com.zspt.app.modulemain.f_course.model.CourseNewModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/11.
 */

public interface ICourseView extends IBaseView {


    void onSuccess(List<CourseNewModel>data);

    void bindHeaderData(List<CourseHeaderModel>data);
}
