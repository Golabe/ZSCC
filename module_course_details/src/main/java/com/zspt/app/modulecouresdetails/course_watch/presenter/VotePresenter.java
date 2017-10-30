package com.zspt.app.modulecouresdetails.course_watch.presenter;

import android.util.Log;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulecouresdetails.api.IVoteApi;
import com.zspt.app.modulecouresdetails.course_watch.model.VoteModel;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.interfaces.IVoteView;

import java.util.List;

/**
 * Created by yuequan on 2017/10/24.
 */

public class VotePresenter extends BasePresenter<IVoteView> {
    private static final String TAG = "VotePresenter";
    public VotePresenter(IVoteView mView) {
        super(mView);
    }

    public void getVoteList() {
        mSubscription = RxManager
                .getInstance()
                .doSubscribe(NetManager
                                .getInstance()
                                .create(IVoteApi.class)
                                .getVoteData()
                        , new RxSubscriber<HttpResult<List<VoteModel>>>(false) {
                            @Override
                            protected void _onNext(HttpResult<List<VoteModel>> data) {
                                if (data.getStatus()==200){
                                    mView.onSuccess(data.getData());
                                }
                                Log.d(TAG, "_onNext: ");
                            }

                            @Override
                            protected void _onError(Throwable e) {
                                Log.d(TAG, "_onError: "+e.toString());
                                mView.onError();
                            }
                        });
    }
}
