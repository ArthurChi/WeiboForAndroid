package com.weibo.cjfire.weibo2android.Home.Model;

/**
 * Created by cjfire on 16/7/19.
 */
public class User {

    private String id;
    private String screen_name;
    private String name;
    private String description;
    private String profile_image_url;

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public String getId() {
        return id;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
