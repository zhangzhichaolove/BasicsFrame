package com.peak.chao.basicsframe.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Chao  2018/3/14 on 11:37
 * description
 */

public class ScrollRecyclerView extends RecyclerView {
    private boolean isScroll;


    public ScrollRecyclerView(Context context) {
        this(context, null);
    }

    public ScrollRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getChildCount() > 0) {
            int itemHeight = getChildAt(0).getMeasuredHeight() * getChildCount();
            int measuredHeight = getMeasuredHeight();
            if (itemHeight > measuredHeight) {
                isScroll = true;
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        //super.onMeasure(widthSpec, heightSpec);
        int size = MeasureSpec.getSize(heightSpec);
        if (getChildCount() > 0) {
            int itemHeight = getChildAt(0).getMeasuredHeight() * getChildCount();
            if (itemHeight < size) {
                setMeasuredDimension(widthSpec, itemHeight);
            } else {
                super.onMeasure(widthSpec, heightSpec);
            }
        } else {
            super.onMeasure(widthSpec, heightSpec);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        invalidate();
    }
}
