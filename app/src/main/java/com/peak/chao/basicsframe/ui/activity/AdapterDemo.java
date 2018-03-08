package com.peak.chao.basicsframe.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.peak.chao.basicsframe.R;
import com.peak.chao.basicsframe.adapter.BaseAdapter;
import com.peak.chao.basicsframe.adapter.ViewHolder;
import com.peak.chao.basicsframe.base.BaseActivity;
import com.peak.chao.basicsframe.injection.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 003 on 2018/3/8.
 */

public class AdapterDemo extends BaseActivity {
    @Id(R.id.rl_list)
    RecyclerView rl_list;


    @Override
    public int getLayout() {
        return R.layout.activity_recycler;
    }

    @Override
    protected void setTitleBar(View layout, TextView tv_title, TextView tv_right) {
        tv_title.setText("适配器测试");
    }

    @Override
    public void initData() {
        rl_list.setLayoutManager(new LinearLayoutManager(mContext));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("模拟数据：" + i);
        }
        rl_list.setAdapter(new BaseAdapter<String>(mContext, list, R.layout.item_rl_list) {
            @Override
            public void onBind(ViewHolder holder, int position, String item) {
                holder.view(R.id.iv_img).setBackgroundResource(R.mipmap.ic_launcher).setText(R.id.tv_name, item);
            }
        });
    }
}
