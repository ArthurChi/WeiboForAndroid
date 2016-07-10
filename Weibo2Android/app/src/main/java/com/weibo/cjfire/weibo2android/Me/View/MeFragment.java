package com.weibo.cjfire.weibo2android.Me.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weibo.cjfire.weibo2android.Base.View.BaseFragment;
import com.weibo.cjfire.weibo2android.R;

/**
 * Created by cjfire on 16/7/10.
 */
public class MeFragment extends BaseFragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = View.inflate(activity, R.layout.fragment_me, null);
        return view;
    }

}
