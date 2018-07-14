package com.arouter.baselibrary;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * date：2018/7/9 on 13:31
 * description:
 */

public class BaseFragment extends Fragment{
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ARouter.getInstance().inject(context);
    }
}
