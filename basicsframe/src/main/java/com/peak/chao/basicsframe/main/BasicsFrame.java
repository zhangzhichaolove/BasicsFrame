package com.peak.chao.basicsframe.main;

import android.content.Context;

/**
 * Created by Chao on 2017-12-23.
 */

public class BasicsFrame {
    private static BasicsFrame instance;
    private Context context;

    private BasicsFrame() {
    }

    public static BasicsFrame getInstance() {
        if (instance == null) {
            synchronized (BasicsFrame.class) {
                if (instance == null) {
                    instance = new BasicsFrame();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
