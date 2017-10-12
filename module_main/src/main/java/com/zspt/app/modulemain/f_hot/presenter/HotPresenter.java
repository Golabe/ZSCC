package com.zspt.app.modulemain.f_hot.presenter;

import android.util.Log;

import com.youth.banner.Banner;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.library_common.net.ApiService;
import com.zspt.app.library_common.net.NetManager;
import com.zspt.app.library_common.rx.RxManager;
import com.zspt.app.library_common.rx.RxSubscriber;
import com.zspt.app.modulemain.R;
import com.zspt.app.modulemain.api.HotApi;
import com.zspt.app.modulemain.f_hot.PicassoImageLoader;
import com.zspt.app.modulemain.f_hot.model.HotModel;
import com.zspt.app.modulemain.f_hot.view.IHotView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuequan on 2017/10/10.
 */

public class HotPresenter extends BasePresenter<IHotView> {
    private static final String TAG = "HotPresenter";
    private List<String> mImageUrl;


    private String name1[] = {
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1",
            "Name1"

    };
    private String name2[] = {
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2",
            "Name2"
    };
    private String name3[] = {
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3",
            "Name3"
    };
    private String name4[] = {
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4",
            "Name4"
    };


    public HotPresenter(IHotView mView) {
        super(mView);
    }

    /**
     * 加载轮播图
     *
     * @param banner
     */
    public void onBanner(Banner banner) {
        mImageUrl = new ArrayList<>();
        mImageUrl.add("http://img.imooc.com/59cf63c00001e89e09360316.jpg");
        mImageUrl.add("http://img.imooc.com/59db0bc00001b70e09360316.jpg");
        mImageUrl.add("http://img.imooc.com/599fff760001c75709360316.jpg");
        mImageUrl.add("http://img.imooc.com/59dc294500018f1309360316.jpg");
        banner.setImages(mImageUrl).setImageLoader(new PicassoImageLoader()).start();


    }

    public void getHotList() {
        List<HotModel> mData = new ArrayList<>();
        for (int i = 0; i < name1.length; i++) {
            mData.add(new HotModel(name1[i],name2[i],name3[i],name4[i]));
        }
        mView.onSuccess(mData);

    }


}
