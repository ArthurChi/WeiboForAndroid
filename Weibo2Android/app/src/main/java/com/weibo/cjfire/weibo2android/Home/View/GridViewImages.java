package com.weibo.cjfire.weibo2android.Home.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by cjfire on 16/7/20.
 */
public class GridViewImages extends GridView {

    public GridViewImages(Context context) {
        super(context);
    }

    public GridViewImages(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}
