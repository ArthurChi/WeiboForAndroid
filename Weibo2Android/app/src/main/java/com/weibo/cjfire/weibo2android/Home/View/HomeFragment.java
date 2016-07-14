package com.weibo.cjfire.weibo2android.Home.View;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.StatusesAPI;
import com.weibo.cjfire.weibo2android.Base.View.BaseFragment;
import com.weibo.cjfire.weibo2android.Me.Manager.LoginManager;
import com.weibo.cjfire.weibo2android.Me.Model.AuthItem;
import com.weibo.cjfire.weibo2android.R;

/**
 * Created by cjfire on 16/7/10.
 */
public class HomeFragment extends BaseFragment {

    private View mView;
    private StatusesAPI statusesAPI;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = View.inflate(mActivity, R.layout.fragment_home, null);

        init();
        return mView;
    }

    private void init() {

        Context context = this.getActivity().getApplicationContext();
        AuthItem authItem = new AuthItem(context);
//        Oauth2AccessToken accessToken = new Oauth2AccessToken(authItem.getAccessToken(), authItem.getExpires());
//        statusesAPI = new StatusesAPI(context, LoginManager.APP_KEY,accessToken);

//        new Thread() {
//
//            public void run() {
//                statusesAPI.friendsTimeline(0, 0, 50, 1, false, 0, false, new RequestListener() {
//                    @Override
//                    public void onComplete(String s) {
//                        Log.i("test", s);
//                    }
//
//                    @Override
//                    public void onWeiboException(WeiboException e) {
//
//                    }
//                });
//            }
//        };
    }
}
