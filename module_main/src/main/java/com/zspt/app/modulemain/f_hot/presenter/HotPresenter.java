package com.zspt.app.modulemain.f_hot.presenter;


import android.util.Log;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulemain.api.IBannerApi;
import com.zspt.app.modulemain.f_hot.model.BannerModel;
import com.zspt.app.modulemain.f_hot.model.HotModel;
import com.zspt.app.modulemain.f_hot.view.IHotView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/10.
 */

public class HotPresenter extends BasePresenter<IHotView> {
    private static final String TAG = "HotPresenter";


    private String name1[] = {
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1"

    };
    private String name2[] = {
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2"
    };
    private String name3[] = {
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3"
    };
    private String name4[] = {
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4"
    };


    public HotPresenter(IHotView mView) {
        super(mView);
    }

    /**
     * 加载轮播图
     */
    public void onBanner() {

        mSubscription = RxManager.getInstance().doSubscribe(NetManager.getInstance().create(IBannerApi.class)
                        .getBanner()
                , new RxSubscriber<HttpResult<List<BannerModel>>>(false) {
                    @Override
                    protected void _onNext(HttpResult<List<BannerModel>> data) {

                        mView.onBannerSuccess(data.getData());
                    }

                    @Override
                    protected void _onError(Throwable e) {
                        Log.d(TAG, "_onError: " + e.toString());
                    }
                });


    }

    public void getHotList() {
        List<HotModel> mData = new ArrayList<>();
        for (int i = 0; i < name1.length; i++) {
            mData.add(new HotModel(name1[i], name2[i], name3[i], name4[i]));
        }
        mView.onSuccess(mData);

    }


}
