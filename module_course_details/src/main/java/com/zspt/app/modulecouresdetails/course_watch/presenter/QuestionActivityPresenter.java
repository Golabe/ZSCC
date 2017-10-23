package com.zspt.app.modulecouresdetails.course_watch.presenter;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulecouresdetails.api.IQuestionSubmitApi;
import com.zspt.app.modulecouresdetails.course_watch.model.QuestionResult;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.IQuestionActivityView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuequan on 2017/10/23.
 */

public class QuestionActivityPresenter extends BasePresenter<IQuestionActivityView> {

    public QuestionActivityPresenter(IQuestionActivityView mView) {
        super(mView);
    }

    public void onSubmit(String title,String content){
        Map<String,String>map=new HashMap<>();
        map.put("username","fsaf");
        map.put("id","id");
        map.put("title",title);
        map.put("content",content);
        mSubscription= RxManager.getInstance()
                .doSubscribe(NetManager.getInstance()
                                .create(IQuestionSubmitApi.class)
                                .getQuesionResultData(map)
                        , new RxSubscriber<HttpResult<QuestionResult>>(false) {
                            @Override
                            protected void _onNext(HttpResult<QuestionResult> questionResultHttpResult) {

                            }

                            @Override
                            protected void _onError(Throwable e) {

                            }
                        });

    }
}
