package com.zspt.app.modulecouresdetails.course_watch.view.fragment;

import com.zspt.app.library_common.base.mvp.IBaseView;
import com.zspt.app.modulecouresdetails.course_watch.model.QuestionLevel0;

import java.util.List;

/**
 * Created by yuequan on 2017/10/11.
 */

public interface IQuestionView extends IBaseView {

    void onSuccess(List<QuestionLevel0>data);

}
