package com.weibo.cjfire.weibo2android.Main.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.weibo.cjfire.weibo2android.Base.Controller.FragmentController;
import com.weibo.cjfire.weibo2android.Base.Controller.ReqService;
import com.weibo.cjfire.weibo2android.Home.Model.Statues;
import com.weibo.cjfire.weibo2android.Me.Manager.LoginManager;
import com.weibo.cjfire.weibo2android.Me.Model.AuthItem;
import com.weibo.cjfire.weibo2android.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by cjfire on 16/6/30.
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private LoginManager loginManager;
    private RadioGroup bottomView;
    private ImageButton addBtn;
    private FragmentController controller;

    public Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginManager = new LoginManager(this);

        setupUI();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.weibo.com/2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AuthItem authItem = new AuthItem(this);

        ReqService service = mRetrofit.create(ReqService.class);
        Call<List<Statues>> statues = service.listStatues(authItem.getAccessToken());

        Log.i("test", statues.toString());
    }

    private void setupUI() {

        bottomView = (RadioGroup) findViewById(R.id.rg_tab);
        addBtn = (ImageButton) findViewById(R.id.iv_add);
        controller = FragmentController.getInstance(this, R.id.fl_content);

        bottomView.setOnCheckedChangeListener(this);
        addBtn.setOnClickListener(this);
    }

    public void auth() {

        AuthItem authItem = new AuthItem(this);

        if (authItem.getExpires().isEmpty()) {
            loginManager.auth();
        } else {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (loginManager.getmSsoHandler() != null) {
            loginManager.getmSsoHandler().authorizeCallBack(requestCode, resultCode, data);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.rb_home:
                controller.showFragment(0);
                break;
            case R.id.rb_message:
                controller.showFragment(1);
                break;
            case R.id.rb_discover:
                controller.showFragment(2);
                break;
            case R.id.rb_me:
                controller.showFragment(3);
                break;
            default:
                break;
        }

    }

    @Override
    public void onClick(View v) {

    }
}


