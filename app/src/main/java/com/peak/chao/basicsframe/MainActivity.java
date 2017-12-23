package com.peak.chao.basicsframe;

import android.widget.ImageView;
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
    protected void setTitleBar(ImageView iv_back, TextView tv_title, TextView tv_right) {
        tv_title.setText("这是标题");
    }

    @Override
    public void initData() {
        tv_content.setText("找ID测试");
    }

    @Override
    protected boolean showTitleBar() {
        return false;
    }
}
