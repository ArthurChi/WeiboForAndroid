package com.weibo.cjfire.weibo2android.Me.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weibo.cjfire.weibo2android.Base.View.BaseFragment;
import com.weibo.cjfire.weibo2android.Main.Controller.MainActivity;
import com.weibo.cjfire.weibo2android.R;

/**
 * Created by cjfire on 16/7/10.
 */
public class MeFragment extends BaseFragment {

    private View mView;
    private Button nLoginBtn;

    private MainActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mActivity = (MainActivity) this.getActivity();
        mView = View.inflate(this.mActivity, R.layout.fragment_me, null);

        nLoginBtn = (Button) mView.findViewById(R.id.loginBtn);
        nLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.auth();
            }
        });

        return mView;
    }

}
