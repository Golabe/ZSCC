package com.zspt.app.modulecouresdetails.course_watch.presenter;

import com.zspt.app.library_common.base.model.HttpResult;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulecouresdetails.api.IQuestionLevel0Api;
import com.zspt.app.modulecouresdetails.course_watch.model.QuestionLevel0;
import com.zspt.app.modulecouresdetails.course_watch.view.fragment.IQuestionView;

import java.util.List;

/**
 * Created by yuequan on 2017/10/11.
 */

public class QuestionPresenter extends BasePresenter<IQuestionView> {
    private static final String TAG = "QuestionPresenter";

    public QuestionPresenter(IQuestionView mView) {
        super(mView);
    }

    public void getQuestionList() {

        mSubscription = RxManager.getInstance().doSubscribe(NetManager.getInstance().create(IQuestionLevel0Api.class).getQuestionData()
                , new RxSubscriber<HttpResult<List<QuestionLevel0>>>(false) {
                    @Override
                    protected void _onNext(HttpResult<List<QuestionLevel0>> data) {

                        if (data.getStatus() == 200) {
                            mView.onSuccess(data.getData());
                        }

                    }

                    @Override
                    protected void _onError(Throwable e) {
                        mView.onError();
                    }
                });
    }
}
