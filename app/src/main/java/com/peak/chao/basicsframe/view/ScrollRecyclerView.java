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
    private float downY;


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
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) ev.getRawY();
                if (isScroll && ((moveY - downY > 0 && canScrollVertically(-1)) || (moveY - downY < 0 && canScrollVertically(1)))) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return super.dispatchTouchEvent(ev);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int size = MeasureSpec.getSize(heightSpec);
        if (getChildCount() > 0) {
            int itemHeight = getChildAt(0).getMeasuredHeight() * getChildCount();
            if (itemHeight < size) {
                setMeasuredDimension(widthSpec, itemHeight);
            } else {
                isScroll = true;
                super.onMeasure(widthSpec, heightSpec);
            }
        } else {
            super.onMeasure(widthSpec, heightSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (getChildCount() > 0) {
            int itemHeight = getChildAt(0).getMeasuredHeight() * getChildCount();
            if (itemHeight > getMeasuredHeight()) {
                isScroll = true;
            }
        }
    }

}
