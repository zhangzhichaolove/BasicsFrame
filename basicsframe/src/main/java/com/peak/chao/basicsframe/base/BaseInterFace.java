package com.peak.chao.basicsframe.base;

/**
 * 基类公共接口
 * Created by Chao on 2017-12-23.
 */

public interface BaseInterFace {

    /**
     * 子类布局
     */
    int getLayout();

    /**
     * 初始化View
     */
    void initView();

    /**
     * 初始化数据
     */
    void initData();

    /**
     * 初始化监听
     */
    void initListener();

}
