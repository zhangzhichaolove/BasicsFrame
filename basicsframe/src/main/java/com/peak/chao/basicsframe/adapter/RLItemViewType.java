package com.peak.chao.basicsframe.adapter;

import android.support.annotation.LayoutRes;

/**
 * Created by 003 on 2018/3/8.
 */

public interface RLItemViewType<T> {

    int getItemViewType(int position, T t);


    @LayoutRes
    int getLayoutId(int viewType);
}
