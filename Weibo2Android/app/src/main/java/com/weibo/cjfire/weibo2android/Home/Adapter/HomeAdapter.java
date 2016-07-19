package com.weibo.cjfire.weibo2android.Home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.weibo.cjfire.weibo2android.Home.Model.Statues;
import com.weibo.cjfire.weibo2android.R;

import java.util.List;

/**
 * Created by cjfire on 16/7/18.
 */
public class HomeAdapter extends BaseAdapter {

    private List<Statues> mStatueList;
    private Context mContext;
    private int mResource;

    public HomeAdapter(Context context, int resource, List<Statues> statueList) {
        super();

        mStatueList = statueList;
        mContext = context;
        mResource = resource;
    }

    @Override
    public int getCount() {
        return mStatueList.size();
    }

    @Override
    public Object getItem(int i) {
        return mStatueList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if (view == null) {

            view = LayoutInflater.from(mContext).inflate(mResource, null);
            holder = new ViewHolder(view);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        String text = mStatueList.get(i).getText();
        holder.showText.setText(text);

        return view;
    }

    class ViewHolder {

        public TextView getShowText() {
            return showText;
        }

        private TextView showText;

        public ViewHolder(View view) {

            showText = (TextView) view.findViewById(R.id.cellHomeText);
        }
    }
}
