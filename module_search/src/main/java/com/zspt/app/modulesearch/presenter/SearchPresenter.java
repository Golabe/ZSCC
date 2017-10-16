package com.zspt.app.modulesearch.presenter;

import com.zspt.app.library_common.base.mvp.BasePresenter;
import com.zspt.app.modulesearch.view.ISearchView;

/**
 * Created by yuequan on 2017/10/16.
 */

public class SearchPresenter extends BasePresenter<ISearchView> {
    public SearchPresenter(ISearchView mView) {
        super(mView);
    }
}
