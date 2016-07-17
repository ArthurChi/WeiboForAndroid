package com.weibo.cjfire.weibo2android.Me.Manager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.weibo.cjfire.weibo2android.Me.Model.AuthItem;

/**
 * Created by cjfire on 16/6/30.
 */

public class LoginManager implements WeiboAuthListener {

    public static final String APP_KEY = "3283806218";
    private static final String REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
    private static final String SCOPE = "all";

    private AppCompatActivity mActivity;
    private AuthInfo mAuthInfo;
    private SsoHandler mSsoHandler;

    private AuthItem mAuthItem;

    public LoginManager(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    public SsoHandler getmSsoHandler() {
        return mSsoHandler;
    }

    public void auth() {

        mAuthInfo = new AuthInfo(mActivity, APP_KEY, REDIRECT_URL, SCOPE);
        mSsoHandler = new SsoHandler(mActivity, mAuthInfo);
        mSsoHandler.authorize(this);
    }

    @Override
    public void onComplete(Bundle values) {
        // 从 Bundle 中解析 Token
        Oauth2AccessToken mAccessToken = Oauth2AccessToken.parseAccessToken(values);
        if (mAccessToken.isSessionValid()) {

            mAuthItem = new AuthItem(values, mActivity);
            mAuthItem.save();

        } else {
            // 当您注册的应用程序签名不正确时，就会收到 Code，请确保签名正确
            String code = values.getString("code", "");

        }
    }

    @Override
    public void onWeiboException(WeiboException e) {

    }

    @Override
    public void onCancel() {
    }

    
}
