package com.zspt.app.modulemain.f_course.presenter;

import android.util.Log;

import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.f_course.model.CourseHeaderModel;
import com.zspt.app.modulemain.f_course.model.CourseNewModel;
import com.zspt.app.modulemain.f_course.view.ICourseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/11.
 */

public class CoursePresenter extends BasePresenter<ICourseView> {
    private static final String TAG = "CoursePresenter";

    private int mCourseHeaderImageId[] = {
            R.drawable.bg_web_page_64,
            R.drawable.bg_bg_64,
            R.drawable.bg_phone_64,
            R.drawable.bg_sql_64,
            R.drawable.bg_yun_64,
            R.drawable.bg_ui_64,};
    private String mCourseHeaderType[] = {
            "前端开发",
            "后端开发",
            "移动开发",
            "数据库",
            "云计算",
            "UI设计"};
    private String name[] = {
            "Rx_java",
            "Rx_android",
            "android",
            "android1",
            "android2",
            "android3",
            "android4",
            "android5",
            "android6",
            "android7",

    };
    private int count[] = {
            1,
            12,
            122,
            1342,
            11,
            18,
            21,
            61,
            21,
            61
    };
    private String level[] = {
            "高级",
            "中级",
            "低级",
            "低级",
            "低级",
            "低级",
            "级",
            "低低级",
            "低级",
            "低级"
    };
    private int imageId[] = {
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
    private List<CourseNewModel> mList = new ArrayList<>();


    public CoursePresenter(ICourseView mView) {
        super(mView);
    }

    public void getNewList() {

        for (int i = 0; i < imageId.length; i++) {
            mList.add(new CourseNewModel(name[i], level[i], imageId[i], count[i]));
        }
        Log.d(TAG, "getNewList: "+mList.get(1).getLevel());
        mView.onSuccess(mList);

    }

    public void getHeaderList(){

       List<CourseHeaderModel> mHeaderData = new ArrayList<>();
        for (int i = 0; i < mCourseHeaderImageId.length; i++) {
            mHeaderData.add(new CourseHeaderModel(mCourseHeaderImageId[i], mCourseHeaderType[i]));
        }

        mView.bindHeaderData(mHeaderData);

    }


}
