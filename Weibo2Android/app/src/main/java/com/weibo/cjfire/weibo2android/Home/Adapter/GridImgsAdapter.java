package com.weibo.cjfire.weibo2android.Home.Adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.gson.internal.LinkedTreeMap;
import com.squareup.picasso.Picasso;
import com.weibo.cjfire.weibo2android.Home.View.GridViewImages;
import com.weibo.cjfire.weibo2android.R;

import java.util.ArrayList;

/**
 * Created by cjfire on 16/7/23.
 */
public class GridImgsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<LinkedTreeMap> picUrls;

    public GridImgsAdapter(Context context, ArrayList<LinkedTreeMap> picUrls) {
        this.context = context;
        this.picUrls = picUrls;

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return picUrls.size();
    }

    @Override
    public Object getItem(int position) {
        return picUrls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_grideview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        GridView gv = (GridView) parent;
        int horizontalSpacing = gv.getHorizontalSpacing();
        int numColumns = gv.getNumColumns();
        int itemWidth = (gv.getWidth() - (numColumns - 1) *horizontalSpacing - gv.getPaddingLeft() - gv.getPaddingRight()) / numColumns;

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(itemWidth, itemWidth);
        holder.mImageView.setLayoutParams(params);

        String urlStr = picUrls.get(position).get("thumbnail_pic").toString();
        Picasso.with(context).load(urlStr).into(holder.mImageView);

        return convertView;
    }

    public static class ViewHolder {
        public ImageView mImageView;

        public ViewHolder(View view) {
            mImageView = (ImageView) view.findViewById(R.id.iv_image);
        }

    }
}
