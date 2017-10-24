package com.zspt.app.modulemain.a_guide;

import com.zspt.app.library_common.base.mvp.IBaseView;
import com.zspt.app.modulemain.a_guide.model.GuideBannerMode;

import java.util.List;

/**
 * Created by yuequan on 2017/10/24.
 */

public interface IGuideView extends IBaseView {
    void onSuccess(List<GuideBannerMode>data);
}
