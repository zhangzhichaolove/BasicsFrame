package com.peak.chao.basicsframe.utils;

import com.peak.chao.basicsframe.config.FrameConfig;

/**
 * Created by Chao  2018/3/9 on 11:35
 * description
 */

public class FrameConstantUtils {

    private static FrameConfig config;
    private static FrameConstantUtils instance;

    private FrameConstantUtils(FrameConfig config) {
        this.config = config;
    }

    public static FrameConstantUtils config(FrameConfig config) {
        if (instance == null) {
            synchronized (FrameConstantUtils.class) {
                if (instance == null) {
                    instance = new FrameConstantUtils(config);
                }
            }
        }
        return instance;
    }

    public static FrameConfig getConfig() {
        if (config == null) {
            FrameConfig.Builder builder = new FrameConfig.Builder();
            config(builder.build());
        }
        return config;
    }

}
