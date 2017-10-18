package com.zspt.app.modulecouresdetails.course_watch.presenter;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulecouresdetails.api.IQuestionDetailsApi;
import com.zspt.app.modulecouresdetails.course_watch.model.QuestionDetailsModel;
import com.zspt.app.modulecouresdetails.course_watch.view.activity.IQuestionDetailsView;

import java.util.List;

/**
 * Created by yuequan on 2017/10/18.
 */

public class QuestionDetailsPresenter extends BasePresenter<IQuestionDetailsView> {

    public QuestionDetailsPresenter(IQuestionDetailsView mView) {
        super(mView);
    }

    public void getQuestionDetailsList(){
        mSubscription= RxManager.getInstance().doSubscribe(NetManager.getInstance().create(IQuestionDetailsApi.class).getQuestionDetailsData()
                , new RxSubscriber<HttpResult<List<QuestionDetailsModel>>>(false) {
                    @Override
                    protected void _onNext(HttpResult<List<QuestionDetailsModel>> listHttpResult) {

                    }

                    @Override
                    protected void _onError(Throwable e) {

                    }
                });
    }


}
