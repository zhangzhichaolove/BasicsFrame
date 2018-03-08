package com.peak.chao.basicsframe.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment基类
 * Created by Chao on 2017-12-23.
 */

public abstract class BaseFragment extends Fragment implements BaseInterFace, View.OnClickListener {
    protected View rootView;
    protected Context mContext;
    private long lastClick = 0;
    private int clickDelay = 200;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayout(), container, false);
        init();
        return rootView;
    }

    private void init() {
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View view) {
        if (!isFastClick()) onWidgetClick(view);
    }

    /**
     * 是否快速点击
     *
     * @return true: 是 false: 否
     */
    private boolean isFastClick() {
        long now = System.currentTimeMillis();
        if (now - lastClick >= clickDelay) {
            lastClick = now;
            return false;
        }
        return true;
    }

    public void setClickDelay(int delay) {
        clickDelay = delay;
    }

    @Override
    public void onWidgetClick(View view) {

    }
}
