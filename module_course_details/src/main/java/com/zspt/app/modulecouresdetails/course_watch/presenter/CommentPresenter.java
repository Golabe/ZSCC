package com.zspt.app.modulecouresdetails.course_watch.presenter;

import android.util.Log;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulecouresdetails.api.ICommentApi;
import com.zspt.app.modulecouresdetails.course_watch.model.CommentModel;
import com.zspt.app.modulecouresdetails.course_watch.view.fragment.ICommentView;

import java.util.List;

/**
 * Created by yuequan on 2017/10/18.
 */

public class CommentPresenter extends BasePresenter<ICommentView> {
    private static final String TAG = "CommentPresenter";

    public CommentPresenter(ICommentView mView) {
        super(mView);
    }

    public void getCommentList() {
        mSubscription = RxManager.getInstance().doSubscribe(NetManager.getInstance().create(ICommentApi.class).getCommentData()

                , new RxSubscriber<HttpResult<List<CommentModel>>>(false) {
                    @Override
                    protected void _onNext(HttpResult<List<CommentModel>> data) {
                        if (data == null) {
                            return;
                        }
                        
                        if (data.getStatus() == 200) {
                            mView.onSuccess(data.getData());
                            Log.d(TAG, "_onNext: "+data.getData().get(1).getName());
                        }
                    }

                    @Override
                    protected void _onError(Throwable e) {
                        Log.d(TAG, "_onError: "+e.toString());
                        mView.onError();
                    }
                });
    }
}
