package com.zspt.app.modulemain.f_study.view;

import com.zspt.app.library_common.base.mvp.IBaseView;
import com.zspt.app.modulemain.f_study.model.StudyHistoryModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/12.
 */

public interface IStudyView extends IBaseView {

    void onSuccess(List<StudyHistoryModel>data);
}
