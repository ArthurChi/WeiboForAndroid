package com.weibo.cjfire.weibo2android.Home.Model;

import java.io.Serializable;

/**
 * Created by cjfire on 16/7/15.
 */
public class Statues implements Serializable {

    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
