package com.zspt.app.library_common.base.mvp;


import rx.Subscription;

/**
 * Created by yuequan on 2017/10/9.
 */

public class BasePresenter<V extends IBaseView> {

    public V mView;

    protected Subscription mSubscription;


    public BasePresenter(V mView) {
        this.mView = mView;
    }

    public void onDetach() {
        mView = null;
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }

}
