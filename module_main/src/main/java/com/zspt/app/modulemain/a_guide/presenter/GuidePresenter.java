package com.zspt.app.modulemain.a_guide.presenter;

import android.util.Log;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulemain.a_guide.IGuideView;
import com.zspt.app.modulemain.a_guide.model.GuideBannerMode;
import com.zspt.app.modulemain.api.IGuideBannerApi;

import java.util.List;

/**
 * Created by yuequan on 2017/10/24.
 */

public class GuidePresenter extends BasePresenter<IGuideView> {
    private static final String TAG = "GuidePresenter";
    public GuidePresenter(IGuideView mView) {
        super(mView);
    }
    public void getBannerData(){
        mSubscription= RxManager.getInstance().doSubscribe(NetManager.getInstance().create(IGuideBannerApi.class).getGuideBannerData()
                , new RxSubscriber<HttpResult<List<GuideBannerMode>>>(false) {
                    @Override
                    protected void _onNext(HttpResult<List<GuideBannerMode>> data) {
                        mView.onSuccess(data.getData());
                        Log.d(TAG, "_onNext: "+data.getStatus());
                    }

                    @Override
                    protected void _onError(Throwable e) {
                        Log.d(TAG, "_onError: "+e.toString());
                        mView.onError();
                    }
                });
    }
}
