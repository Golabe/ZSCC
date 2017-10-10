package com.zspt.app.modulemain.f_hot;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by yuequan on 2017/10/10.
 */

public class PicassoImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {


        //Picasso 加载图片简单用法
        Picasso.with(context).load((String) path).into(imageView);
    }
}
