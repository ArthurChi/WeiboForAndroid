package com.weibo.cjfire.weibo2android.Home.Model;

import android.util.ArrayMap;

import com.google.gson.internal.LinkedTreeMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by cjfire on 16/7/15.
 * Source: http://open.weibo.com/wiki/常见返回对象数据结构#.E5.BE.AE.E5.8D.9A.EF.BC.88status.EF.BC.89
 */
public class Statues implements Serializable {

    private String id;
    private String text;
    private String source;
    private Boolean favorited;
    private Boolean truncated;
    private Integer reposts_count;
    private Integer comments_count;
    private String created_at;
    private User user;
    private Statues retweeted_status;
    private String thumbnail_pic;
    private ArrayList<LinkedTreeMap> pic_urls;

    public String getThumbnail_pic() {
        return thumbnail_pic;
    }

    public ArrayList<LinkedTreeMap> getPic_url() {
        return pic_urls;
    }

    public Statues getRetweeted_status() { return retweeted_status; }

    public String getCreated_at() {
        return created_at;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getSource() {
        return source;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public Boolean getTruncated() {
        return truncated;
    }

    public Integer getReposts_count() {
        return reposts_count;
    }

    public Integer getComments_count() {
        return comments_count;
    }

    public User getUser() {
        return user;
    }
}
