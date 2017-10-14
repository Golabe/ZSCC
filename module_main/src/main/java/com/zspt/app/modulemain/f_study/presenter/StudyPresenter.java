package com.zspt.app.modulemain.f_study.presenter;

import android.util.Log;

import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.api.StudyApi;
import com.zspt.app.modulemain.f_study.model.StudyHistoryModel;
import com.zspt.app.modulemain.f_study.view.IStudyView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/12.
 */

public class StudyPresenter extends BasePresenter<IStudyView> {
    private static final String TAG = "StudyPresenter";

    private String name[]={
            "Google",
            "Android",
            "Google",
            "Android",
            "Google",
            "Android",
            "Google",
            "Android",
            "Google",
            "Android"
    };
    private int progress[]={
            20,
            60,
            20,
            60,
            20,
            60,
            20,
            60,
            20,
            60

    };
    private int imageUrl[]={
           R.mipmap.ic_launcher,
           R.mipmap.ic_launcher,
           R.mipmap.ic_launcher,
           R.mipmap.ic_launcher,
           R.mipmap.ic_launcher,
           R.mipmap.ic_launcher,
           R.mipmap.ic_launcher,
           R.mipmap.ic_launcher,
           R.mipmap.ic_launcher,
           R.mipmap.ic_launcher

    };
    public StudyPresenter(IStudyView mView) {
        super(mView);
    }

    public void getStudyList() {
        List<StudyHistoryModel>mData=new ArrayList<>();
//        mSubscription = RxManager.getInstance().
//                doSubscribe(NetManager.getInstance().create(StudyApi.class).getStudyData("rankingRise?resourceType=0,2&page=1&size=20&type=json"), new RxSubscriber<List<StudyHistoryModel>>(false) {
//                    @Override
//                    protected void _onNext(List<StudyHistoryModel> studyModels) {
//                        Log.d(TAG, "_onNext: " + studyModels.get(1).getId());
//                    }
//
//                    @Override
//                    protected void _onError(Throwable e) {
//                        Log.d(TAG, "_onError: " + e.toString());
//                    }
//                });
        for (int i=0;i<imageUrl.length;i++){
            mData.add(new StudyHistoryModel(name[i],imageUrl[i],progress[i]));

        }
        mView.onSuccess(mData);





    }
}
