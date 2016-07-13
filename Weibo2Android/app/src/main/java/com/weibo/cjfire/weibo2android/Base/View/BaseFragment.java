package com.weibo.cjfire.weibo2android.Base.View;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import com.weibo.cjfire.weibo2android.Main.Controller.MainActivity;

/**
 * Created by cjfire on 16/7/10.
 */
public class BaseFragment extends Fragment {

    protected MainActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = (MainActivity) getActivity();
    }

    protected void intent2Activity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(mActivity, tarActivity);
        startActivity(intent);
    }
}
