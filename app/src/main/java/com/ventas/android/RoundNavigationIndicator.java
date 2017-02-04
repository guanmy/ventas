package com.ventas.android;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by guanmy on 2017/2/4.
 */

public class RoundNavigationIndicator extends LinearLayout {

    private Context mContext;

    public RoundNavigationIndicator(Context context) {
        super(context);

        init(context);
    }


    public RoundNavigationIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void setLength(int length) {

        for (int i = 0; i < length; i++) {
            ImageView imageView = new ImageView(mContext);
            LayoutParams layoutParams = new LayoutParams(20, 20);
            layoutParams.setMargins(8, 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }
            addView(imageView);
        }
    }

    public void setSelected(int position) {
        int length = getChildCount();
        for (int i = 0; i < length; i++) {
            ImageView imageView = (ImageView)getChildAt(i);
            if (i == position) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }
        }
    }

    private void init(Context context) {
        mContext = context;
        setOrientation(HORIZONTAL);
    }
}
