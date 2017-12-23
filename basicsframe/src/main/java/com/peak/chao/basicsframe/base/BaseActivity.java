package com.peak.chao.basicsframe.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.peak.chao.basicsframe.injection.FindView;

/**
 * Activity基类
 * Created by Chao on 2017-12-23.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseInterFace {
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayout());
        init();
    }

    private void init() {
        FindView.bind(this);
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
}
