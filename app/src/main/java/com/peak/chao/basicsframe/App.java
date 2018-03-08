package com.peak.chao.basicsframe;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.peak.chao.basicsframe.main.BasicsFrame;

/**
 * Created by Chao on 2017-12-23.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        BasicsFrame.getInstance().init(this);
    }
}
