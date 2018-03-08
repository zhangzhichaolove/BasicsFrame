package com.peak.chao.basicsframe;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.peak.chao.basicsframe.base.BaseActivity;
import com.peak.chao.basicsframe.injection.Id;
import com.peak.chao.basicsframe.utils.ToastUtils;

public class MainActivity extends BaseActivity {
    @Id(R.id.tv_content)
    TextView tv_content;
    private int i = 1;

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
        tv_content.setOnClickListener(this);
        setClickDelay(1000);
    }

    @Override
    protected boolean showTitleBar() {
        return false;
    }

    @Override
    public void onWidgetClick(View view) {
        i++;
        ToastUtils.showToast("现在输出：" + i);
    }
}
