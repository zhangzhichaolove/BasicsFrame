package com.peak.chao.basicsframe.utils;

import android.widget.Toast;

import com.peak.chao.basicsframe.main.BasicsFrame;

/**
 * Toast工具类
 * Created by Chao on 2017-12-23.
 */

public class ToastUtils {
    private static Toast toast;

    public static void showToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(BasicsFrame.getInstance().getContext(), "", Toast.LENGTH_LONG);
        }
        toast.setText(msg.toString());
        toast.show();
    }
}
