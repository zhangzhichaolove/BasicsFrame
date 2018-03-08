package com.peak.chao.basicsframe.adapter;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 003 on 2018/3/8.
 */

public class ExtendViewHolder {

    private static ExtendViewHolder instance;
    private View view;
    private ViewHolder viewHolder;

    public static ExtendViewHolder getInstance(ViewHolder viewHolder, View textView) {
        instance = new ExtendViewHolder(viewHolder, textView);
        return instance;
    }

    private ExtendViewHolder(ViewHolder viewHolder, View view) {
        this.view = view;
        this.viewHolder = viewHolder;
    }

//    public ExtendViewHolder view(int viewId) {
//        return viewHolder.view(viewId);
//    }


    public ExtendViewHolder setTag(Object tag) {
        view.setTag(tag);
        return this;
    }

    public ExtendViewHolder setOnClickListener(View.OnClickListener listener) {
        view.setOnClickListener(listener);
        return this;
    }


    public ExtendViewHolder setBackground(Drawable background) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(background);
        }
        return this;
    }

    public ExtendViewHolder setBackgroundColor(@ColorInt int color) {
        view.setBackgroundColor(color);
        return this;
    }

    public ExtendViewHolder setBackgroundResource(@DrawableRes int resid) {
        view.setBackgroundResource(resid);
        return this;
    }

    public ExtendViewHolder setScaleType(ImageView.ScaleType scaleType) {
        if (view instanceof ImageView) {
            ((ImageView) view).setScaleType(scaleType);
        }
        return this;
    }

    public ExtendViewHolder setText(CharSequence text) {
        if (view instanceof TextView) {//Button、EditText等控件继承自TextView
            ((TextView) view).setText(text);
        }
        return this;
    }

    public ExtendViewHolder setText(int id, CharSequence text) {
        View findView = viewHolder.findViewById(id);
        if (findView instanceof TextView) {//Button、EditText等控件继承自TextView
            ((TextView) findView).setText(text);
        }
        return this;
    }

    public ExtendViewHolder setTextColor(@ColorInt int color) {
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(color);
        }
        return this;
    }

    public ExtendViewHolder setTextSize(float size) {
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(size);
        }
        return this;
    }
}
