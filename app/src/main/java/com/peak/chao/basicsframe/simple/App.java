package com.peak.chao.basicsframe.simple;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.peak.chao.basicsframe.config.FrameConfig;
import com.peak.chao.basicsframe.main.BasicsFrame;
import com.peak.chao.basicsframe.utils.FrameConstantUtils;

/**
 * Created by Chao on 2017-12-23.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        FrameConfig.Builder builder = new FrameConfig.Builder().deBug(true);
        FrameConstantUtils.config(builder.build());
        BasicsFrame.getInstance().init(this);
    }
}
