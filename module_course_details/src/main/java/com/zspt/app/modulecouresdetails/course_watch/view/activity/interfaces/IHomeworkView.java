package com.zspt.app.modulecouresdetails.course_watch.view.activity.interfaces;

import com.zspt.app.library_common.base.mvp.IBaseView;
import com.zspt.app.modulecouresdetails.course_watch.model.HomeworkModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/23.
 */

public interface IHomeworkView extends IBaseView {

    void onSuccess(List<HomeworkModel>data);
}
