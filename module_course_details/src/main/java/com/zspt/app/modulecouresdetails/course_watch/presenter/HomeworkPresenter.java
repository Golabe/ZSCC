package com.zspt.app.modulecouresdetails.course_watch.presenter;

import android.util.Log;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulecouresdetails.api.IHomeworkApi;
import com.zspt.app.modulecouresdetails.course_watch.model.HomeworkModel;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.IHomeworkView;

import java.util.List;

/**
 * Created by yuequan on 2017/10/23.
 */

public class HomeworkPresenter extends BasePresenter<IHomeworkView> {
    private static final String TAG = "HomeworkPresenter";

    public HomeworkPresenter(IHomeworkView mView) {
        super(mView);
    }
    public void getHomeworkList(){
        mSubscription= RxManager.getInstance()
                .doSubscribe(NetManager.getInstance().create(IHomeworkApi.class)
                                .getHomeworkData()
                        , new RxSubscriber<HttpResult<List<HomeworkModel>>>(false) {
                            @Override
                            protected void _onNext(HttpResult<List<HomeworkModel>> data) {
                                    mView.onSuccess(data.getData());
                                Log.d(TAG, "_onNext: ");
                            }

                            @Override
                            protected void _onError(Throwable e) {
                                Log.d(TAG, "_onError: ");
                                mView.onError();
                            }
                        });
    }
}
