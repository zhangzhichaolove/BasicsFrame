package com.peak.chao.basicsframe.adapter;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 003 on 2018/3/8.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    /**
     * 在put数据之前，会先查找要put的数据是否已经存在，如果存在就是修改，不存在就添加。
     */
    private SparseArray<View> childViews = new SparseArray<>();

    private View view;

    public ViewHolder(View itemView) {
        super(itemView);
    }

    @Deprecated
    public <T extends View> T getView(int id) {
        return findViewById(id);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T findViewById(int id) {
        View childView = childViews.get(id);
        if (childView == null) {
            childView = itemView.findViewById(id);
            if (childView != null) {
                childViews.put(id, childView);
            }
        }
        view = childView;
        return (T) childView;
    }


//    public ExtendViewHolder view(int viewId) {
//        return ExtendViewHolder.getInstance(this, findViewById(viewId));
//    }

    public ViewHolder view(int viewId) {
        findViewById(viewId);
        return this;
    }


    public ViewHolder setTag(Object tag) {
        view.setTag(tag);
        return this;
    }

    public ViewHolder setOnClickListener(View.OnClickListener listener) {
        view.setOnClickListener(listener);
        return this;
    }


    public ViewHolder setBackground(Drawable background) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(background);
        }
        return this;
    }

    public ViewHolder setBackgroundColor(@ColorInt int color) {
        view.setBackgroundColor(color);
        return this;
    }

    public ViewHolder setBackgroundResource(@DrawableRes int resid) {
        view.setBackgroundResource(resid);
        return this;
    }

    public ViewHolder setScaleType(ImageView.ScaleType scaleType) {
        if (view instanceof ImageView) {
            ((ImageView) view).setScaleType(scaleType);
        }
        return this;
    }

    public ViewHolder setText(CharSequence text) {
        if (view instanceof TextView) {//Button、EditText等控件继承自TextView
            ((TextView) view).setText(text);
        }
        return this;
    }

    public ViewHolder setText(int viewId, CharSequence text) {
        View findView = findViewById(viewId);
        if (findView instanceof TextView) {//Button、EditText等控件继承自TextView
            ((TextView) findView).setText(text);
        }
        return this;
    }

    public ViewHolder setTextColor(@ColorInt int color) {
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(color);
        }
        return this;
    }

    public ViewHolder setTextSize(float size) {
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(size);
        }
        return this;
    }
}
