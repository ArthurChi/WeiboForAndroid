package com.weibo.cjfire.weibo2android.WeiboAPI;

import android.os.Bundle;
import android.util.Log;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;

/**
 * Created by cjfire on 16/7/13.
 */
class AuthListener implements WeiboAuthListener {

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

    @Override
    public void onWeiboException(WeiboException e) {
    }
}
