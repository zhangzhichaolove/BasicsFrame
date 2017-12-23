package com.peak.chao.basicsframe;

import android.widget.TextView;

import com.peak.chao.basicsframe.base.BaseActivity;
import com.peak.chao.basicsframe.injection.Id;

public class MainActivity extends BaseActivity {
    @Id(R.id.tv_content)
    TextView tv_content;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        tv_content.setText("通过注解找到了ID");
    }
}
