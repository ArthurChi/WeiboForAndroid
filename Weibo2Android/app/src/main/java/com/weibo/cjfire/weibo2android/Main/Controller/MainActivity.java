package com.weibo.cjfire.weibo2android.Main.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.weibo.cjfire.weibo2android.Me.Manager.LoginManager;
import com.weibo.cjfire.weibo2android.Me.Model.AuthItem;
import com.weibo.cjfire.weibo2android.R;

/**
 * Created by cjfire on 16/6/30.
 */
public class MainActivity extends AppCompatActivity {

    private LoginManager loginManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginManager = new LoginManager(this);
    }

    public void authBtnDidClicked(View view) {

        AuthItem authItem = new AuthItem(this);

        Log.i("test", authItem.getUid());

        if (authItem.getExpires().isEmpty()) {
            loginManager.auth();
        } else {
            Log.i("test", authItem.getUid());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (loginManager.getmSsoHandler() != null) {
            loginManager.getmSsoHandler().authorizeCallBack(requestCode, resultCode, data);
        }
    }
}


