package com.weibo.cjfire.weibo2android.Main.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.weibo.cjfire.weibo2android.R;

/**
 * Created by cjfire on 16/6/30.
 */
public class MainActivity extends AppCompatActivity {

    private static final String APP_KEY = "3283806218";
    private static final String REDIRECT_URL = "0993b0ccb43bb38d0acd230477f172d6";

    private static final String SCOPE = "all";

    AuthInfo mAuthInfo;
    SsoHandler mSsoHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuthInfo = new AuthInfo(this, MainActivity.APP_KEY, "https://api.weibo.com/oauth2/default.html", MainActivity.SCOPE);
    }

    public void authBtnDidClicked(View view) {
        mSsoHandler = new SsoHandler(this, mAuthInfo);
        mSsoHandler.authorize(new AuthListener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (mSsoHandler != null) {
            mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }
}

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

