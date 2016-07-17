package com.weibo.cjfire.weibo2android.Base.Controller;

import com.weibo.cjfire.weibo2android.Home.Model.Statues;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cjfire on 16/7/15.
 */
public interface ReqService {

    @GET("statuses/public_timeline.json")
    Call<List<Statues>> listStatues(@Query("access_token") String accessToken);
}
