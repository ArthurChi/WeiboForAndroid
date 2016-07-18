package com.weibo.cjfire.weibo2android.Home.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.weibo.cjfire.weibo2android.Home.Model.Statues;

import java.util.List;

/**
 * Created by cjfire on 16/7/18.
 */
public class HomeAdapter extends ArrayAdapter {

    private List<Statues> mStatueList;

    public HomeAdapter(Context context, int resource, List<Statues> statueList) {
        super(context, resource);

        mStatueList = statueList;
    }

    @Override
    public int getCount() {
        return mStatueList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
