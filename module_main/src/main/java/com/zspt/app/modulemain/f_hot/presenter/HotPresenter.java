package com.zspt.app.modulemain.f_hot.presenter;

import com.youth.banner.Banner;
import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.modulemain.f_hot.PicassoImageLoader;
import com.zspt.app.modulemain.f_hot.view.IHotView;

import java.util.List;

/**
 * Created by yuequan on 2017/10/10.
 */

public class HotPresenter extends BasePresenter<IHotView> {


    public HotPresenter(IHotView mView) {
        super(mView);
    }


    /**
     * 加载轮播图
     * @param banner
     * @param imageUrl
     */
    public void onBanner(Banner banner,List<String> imageUrl){

        imageUrl.add("http://img.imooc.com/59cf63c00001e89e09360316.jpg");
        imageUrl.add("http://img.imooc.com/59db0bc00001b70e09360316.jpg");
        imageUrl.add("http://img.imooc.com/599fff760001c75709360316.jpg");
        imageUrl.add("http://img.imooc.com/59dc294500018f1309360316.jpg");
        banner.setImages(imageUrl).setImageLoader(new PicassoImageLoader()).start();


    }


}
