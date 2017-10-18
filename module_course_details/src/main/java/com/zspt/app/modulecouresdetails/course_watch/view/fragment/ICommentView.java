package com.zspt.app.modulecouresdetails.course_watch.view.fragment;

import com.zspt.app.library_common.base.mvp.IBaseView;
import com.zspt.app.modulecouresdetails.course_watch.model.CommentModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/18.
 */

public interface ICommentView extends IBaseView {
    void onSuccess(List<CommentModel>data);
}
