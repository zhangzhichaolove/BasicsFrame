package com.peak.chao.basicsframe.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 003 on 2018/3/8.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    /**
     * 在put数据之前，会先查找要put的数据是否已经存在，如果存在就是修改，不存在就添加。
     */
    private SparseArray<View> childViews = new SparseArray<>();

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
        return (T) childView;
    }


    public ExtendViewHolder view(int viewId) {
        return ExtendViewHolder.getInstance(this, findViewById(viewId));
    }

    public ViewHolder setText(int viewId, CharSequence text) {
        View findView = findViewById(viewId);
        if (findView instanceof TextView) {//Button、EditText等控件继承自TextView
            ((TextView) findView).setText(text);
        }
        return this;
    }
}
