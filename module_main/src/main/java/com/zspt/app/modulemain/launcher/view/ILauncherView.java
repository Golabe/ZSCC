package com.zspt.app.modulemain.launcher.view;

import com.zspt.app.library_common.base.mvp.IBaseView;
import com.zspt.app.modulemain.launcher.model.LauncherModel;

/**
 * Created by yuequan on 2017/10/16.
 */

public interface ILauncherView extends IBaseView {
    void onSuccess(LauncherModel data);

}
