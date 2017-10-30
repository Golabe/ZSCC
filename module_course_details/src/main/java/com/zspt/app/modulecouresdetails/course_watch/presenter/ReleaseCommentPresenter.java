package com.zspt.app.modulecouresdetails.course_watch.presenter;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulecouresdetails.api.IReleaseCommentApi;
import com.zspt.app.modulecouresdetails.course_watch.model.ReleaseCommentModel;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.interfaces.IReleaseCommentView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuequan on 2017/10/25.
 */

public class ReleaseCommentPresenter extends BasePresenter<IReleaseCommentView> {
    public ReleaseCommentPresenter(IReleaseCommentView mView) {
        super(mView);
    }

    public void releaseComment(ReleaseCommentModel commentModel){
        Map<String,String>map=new HashMap<>();
        map.put("userId",commentModel.getUserId());
        map.put("courseId", String.valueOf(commentModel.getCourseId()));
        map.put("comment",commentModel.getComment());
        map.put("username",commentModel.getUsername());

        mSubscription= RxManager
                .getInstance()
                .doSubscribe(NetManager
                                .getInstance()
                                .create(IReleaseCommentApi.class)
                                .releaseComment(map)
                        , new RxSubscriber<HttpResult>(false) {
                            @Override
                            protected void _onNext(HttpResult httpResult) {

                            }

                            @Override
                            protected void _onError(Throwable e) {

                            }
                        });
    }
}
