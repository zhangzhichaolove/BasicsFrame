package com.peak.chao.basicsframe;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.peak.chao.basicsframe.base.BaseActivity;
import com.peak.chao.basicsframe.injection.Id;
import com.peak.chao.basicsframe.ui.activity.AdapterDemo;
import com.peak.chao.basicsframe.ui.activity.WebActivity;

public class MainActivity extends BaseActivity {
    @Id(R.id.tv_content)
    TextView tv_content;
    @Id(R.id.btn_adapter)
    Button btn_adapter;
    private int i = 1;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setTitleBar(View layout, TextView tv_title, TextView tv_right) {
        layout.findViewById(R.id.iv_back).setVisibility(View.GONE);
        tv_title.setText("首页");
    }

    @Override
    public void initData() {
        tv_content.setText("找ID测试");
        tv_content.setOnClickListener(this);
        setClickDelay(1000);
        startActivity(new Intent(this, WebActivity.class).putExtra(WebActivity.WEB_URL, "file:///android_asset/ClickTest.html"));
    }

    @Override
    public void initListener() {
        btn_adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdapterDemo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected boolean showTitleBar() {
        return true;
    }

    @Override
    public void onWidgetClick(View view) {
        i++;
        ToastUtils.showShort("现在输出：" + i);
    }
}
