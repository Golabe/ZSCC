package com.zspt.app.modulecouresdetails.course_watch.presenter;

import android.util.Log;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulecouresdetails.api.IHomeworkDetailsApi;
import com.zspt.app.modulecouresdetails.course_watch.model.HomeworkDetailsModel;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.IHomeworkDetailsView;

import java.util.List;

/**
 * Created by yuequan on 2017/10/24.
 */

public class HomeworkDetailsPresenter extends BasePresenter<IHomeworkDetailsView> {
    private static final String TAG = "HomeworkDetailsPresente";
    public HomeworkDetailsPresenter(IHomeworkDetailsView mView) {
        super(mView);
    }
    public void getHomeworkDetailsList(){
        mSubscription= RxManager.getInstance().doSubscribe(NetManager.getInstance().create(IHomeworkDetailsApi.class).gethomeworkDetailsData()
                , new RxSubscriber<HttpResult<List<HomeworkDetailsModel>>>(false) {
                    @Override
                    protected void _onNext(HttpResult<List<HomeworkDetailsModel>> data) {
                        Log.d(TAG, "_onNext: "+data.getStatus());

                        mView.onSuccess(data.getData());
                    }

                    @Override
                    protected void _onError(Throwable e) {
                        Log.d(TAG, "_onError: "+e.toString());
                        mView.onError();
                    }
                });
    }
}
