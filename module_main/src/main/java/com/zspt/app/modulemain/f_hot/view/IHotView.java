package com.zspt.app.modulemain.f_hot.view;

import com.zspt.app.library_common.base.mvp.IBaseView;
import com.zspt.app.modulemain.f_hot.model.BannerModel;
import com.zspt.app.modulemain.f_hot.model.HotModel;

import java.util.List;

/**
 * Created by yuequan on 2017/10/10.
 */

public interface IHotView extends IBaseView {
    void onSuccess(List<HotModel>data);

    void onBannerSuccess(List<BannerModel>data);
    void onBannerError();

}
