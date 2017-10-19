package com.zspt.app.modulemain.f_study.presenter;



import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.modulemain.R;
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
        for (int i=0;i<imageUrl.length;i++){
            mData.add(new StudyHistoryModel(name[i],imageUrl[i],progress[i]));

        }
        mView.onSuccess(mData);





    }
}
