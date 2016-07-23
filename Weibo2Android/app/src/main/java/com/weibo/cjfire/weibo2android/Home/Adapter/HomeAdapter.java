package com.weibo.cjfire.weibo2android.Home.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.internal.LinkedTreeMap;
import com.squareup.picasso.Picasso;
import com.weibo.cjfire.weibo2android.Home.Model.Statues;
import com.weibo.cjfire.weibo2android.Home.Model.User;
import com.weibo.cjfire.weibo2android.Home.View.GridViewImages;
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

        Statues statues = mStatueList.get(i);
        User user = statues.getUser();

        Picasso.with(mContext).load(user.getProfile_image_url()).into(holder.mUserAvatar);
        holder.mUserNickName.setText(statues.getUser().getName());
        holder.mShowTimeSource.setText(statues.getSource());

        holder.showText.setText(statues.getText());

        setImages(statues, holder.mImgFrameLayout, holder.mImgs, holder.mSingleImg);

        Statues retweeter = statues.getRetweeted_status();

        if (retweeter == null) {
            holder.mRetweeterLayout.setVisibility(View.GONE);
        } else {
            holder.mRetweeterLayout.setVisibility(View.VISIBLE);
            holder.mRetweeterTextView.setText(retweeter.getText());

            setImages(retweeter, holder.mRetweeterImgFrameLayout, holder.mRetweeterImgs, holder.mRetweeterImg);
        }

        return view;
    }

    private void setImages(Statues statues, FrameLayout mImgFrameLayout, GridViewImages mImgs, ImageView mSingleImg) {

        if (statues.getPic_url() != null) {
            mImgFrameLayout.setVisibility(View.VISIBLE);

            if (statues.getPic_url().size() == 1) {
                mImgs.setVisibility(View.GONE);
                mSingleImg.setVisibility(View.VISIBLE);
                Picasso.with(mContext).load(statues.getPic_url().get(0).get("thumbnail_pic").toString()).into(mSingleImg);

            } else  {
                mSingleImg.setVisibility(View.GONE);
                mImgs.setVisibility(View.VISIBLE);
            }

        } else {
            mImgFrameLayout.setVisibility(View.GONE);
        }
    }

    class ViewHolder {

        private ImageButton mUserAvatar;
        private TextView mUserNickName;
        private TextView mShowTimeSource;
        private TextView showText;

        private FrameLayout mImgFrameLayout;
        private GridViewImages mImgs;
        private ImageView mSingleImg;

        private LinearLayout mRetweeterLayout;
        private TextView mRetweeterTextView;
        private FrameLayout mRetweeterImgFrameLayout;
        private GridViewImages mRetweeterImgs;
        private ImageView mRetweeterImg;

        public ViewHolder(View view) {

            mUserAvatar = (ImageButton) view.findViewById(R.id.cellAuthorAvatar);
            mUserNickName = (TextView) view.findViewById(R.id.cellAuthorNickname);
            mShowTimeSource = (TextView) view.findViewById(R.id.cellAuthorTimeSource);
            showText = (TextView) view.findViewById(R.id.cellHomeText);

            mImgFrameLayout = (FrameLayout) view.findViewById(R.id.include_status_image);
            mImgs = (GridViewImages) mImgFrameLayout.findViewById(R.id.dv_images);
            mSingleImg = (ImageView) mImgFrameLayout.findViewById(R.id.cellSingleImage);

            mRetweeterLayout = (LinearLayout) view.findViewById(R.id.include_retweeted_status);
            mRetweeterTextView = (TextView) mRetweeterLayout.findViewById(R.id.tv_retweeted_content);

            mRetweeterImgFrameLayout = (FrameLayout) mRetweeterLayout.findViewById(R.id.include_status_image);
            mRetweeterImgs = (GridViewImages) mRetweeterImgFrameLayout.findViewById(R.id.dv_images);
            mRetweeterImg = (ImageView) mRetweeterImgFrameLayout.findViewById(R.id.cellSingleImage);
        }
    }
}
