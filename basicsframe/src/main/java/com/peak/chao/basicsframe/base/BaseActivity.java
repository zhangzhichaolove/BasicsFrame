package com.peak.chao.basicsframe.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.peak.chao.basicsframe.R;
import com.peak.chao.basicsframe.injection.FindView;

/**
 * Activity基类
 * Created by Chao on 2017-12-23.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseInterFace {
    protected Context mContext;
    LinearLayout ll_content;
    ImageView iv_back;
    TextView tv_title;
    TextView tv_right;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_base);
        ll_content = findViewById(R.id.ll_content);
        init();
    }

    private void init() {
        initContent();
        FindView.bind(this);
        initView();
        initData();
        initListener();
    }

    private void initContent() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (showTitleBar()) {
            View titleBar = inflater.inflate(R.layout.include_title_bar, ll_content);
            iv_back = titleBar.findViewById(R.id.iv_back);
            tv_title = titleBar.findViewById(R.id.tv_title);
            tv_right = titleBar.findViewById(R.id.tv_right);
            iv_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
            setTitleBar(iv_back, tv_title, tv_right);
        }
        inflater.inflate(getLayout(), ll_content);
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

    /**
     * 是否加载标题栏,子类可复写
     */
    protected boolean showTitleBar() {
        return true;
    }

    protected abstract void setTitleBar(ImageView iv_back, TextView tv_title, TextView tv_right);

}
