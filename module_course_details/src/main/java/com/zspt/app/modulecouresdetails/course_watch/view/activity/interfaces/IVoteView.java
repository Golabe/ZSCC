package com.zspt.app.modulecouresdetails.course_watch.view.activity.interfaces;

import com.zspt.app.library_common.base.mvp.IBaseView;
import com.zspt.app.modulecouresdetails.course_watch.model.VoteModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/24.
 */

public interface IVoteView extends IBaseView {
    void onSuccess(List<VoteModel>data);
}
