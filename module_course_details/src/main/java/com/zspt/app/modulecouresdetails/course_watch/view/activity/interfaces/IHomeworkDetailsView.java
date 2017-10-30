package com.zspt.app.modulecouresdetails.course_watch.view.activity.interfaces;

import com.zspt.app.library_common.base.mvp.IBaseView;
import com.zspt.app.modulecouresdetails.course_watch.model.HomeworkDetailsModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/23.
 */

public interface IHomeworkDetailsView extends IBaseView {
    void onSuccess(List<HomeworkDetailsModel>data);
}
