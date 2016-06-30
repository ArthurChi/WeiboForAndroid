package com.weibo.cjfire.weibo2android.Me.Manager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

/**
 * Created by cjfire on 16/6/30.
 */

public class LoginManager implements WeiboAuthListener {

    private static final String APP_KEY = "3283806218";
    private static final String REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
    private static final String SCOPE = "all";

    private AppCompatActivity activity;
    private AuthInfo mAuthInfo;
    private SsoHandler mSsoHandler;

    public LoginManager(AppCompatActivity activity) {
        this.activity = activity;
    }

    public SsoHandler getmSsoHandler() {
        return mSsoHandler;
    }

    public void auth() {

        mAuthInfo = new AuthInfo(activity, APP_KEY, REDIRECT_URL, SCOPE);
        mSsoHandler = new SsoHandler(activity, mAuthInfo);
        mSsoHandler.authorize(this);
    }

    @Override
    public void onComplete(Bundle values) {
        // 从 Bundle 中解析 Token
        Oauth2AccessToken mAccessToken = Oauth2AccessToken.parseAccessToken(values);
        if (mAccessToken.isSessionValid()) {
            // 保存 Token 到 SharedPreferences
            String uid = values.getString("uid");
            String userName = values.getString("userName");
            Integer expires = values.getInt("expires_in");
            String refreshToken = values.getString("refresh_token");
            String accessToken = values.getString("access_token");

            Log.i("test", accessToken);
        } else {
            // 当您注册的应用程序签名不正确时，就会收到 Code，请确保签名正确
            String code = values.getString("code", "");

        }
    }

    @Override
    public void onCancel() {
    }

    
}
