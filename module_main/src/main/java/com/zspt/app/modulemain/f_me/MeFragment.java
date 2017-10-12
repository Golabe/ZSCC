package com.zspt.app.modulemain.f_me;

import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zspt.app.library_common.base.fragment.BaseMvpFragment;
import com.zspt.app.modulemain.R;

/**
 * Created by yuequan on 2017/10/10.
 */

public class MeFragment extends BaseMvpFragment {
    private Button mButton;
    @Override
    protected void fetchData() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        mButton=$(R.id.me_arouter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/ModuleCourseDetails/CourseDetailsActivity").navigation();

            }
        });

    }

    @Override
    protected void initData() {

    }
}
