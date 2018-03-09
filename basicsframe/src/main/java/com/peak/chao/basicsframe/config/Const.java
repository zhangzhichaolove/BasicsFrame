package com.peak.chao.basicsframe.config;

import android.os.Environment;

import com.peak.chao.basicsframe.main.BasicsFrame;

import java.io.File;

/**
 * Created by Chao  2018/3/9 on 11:19
 * description
 */

public interface Const {
    public String rootPath = Environment.getExternalStorageDirectory()
            + File.separator;// 获取sd卡目录

    public String dataPath = Environment.getDataDirectory()
            + File.separator;// 获取sd卡目录

    public String packageDataPath = Environment.getDataDirectory()
            + File.separator + BasicsFrame.getInstance().getContext().getPackageName() + File.separator;

    public String packagePath = Environment.getExternalStorageDirectory()
            + File.separator + BasicsFrame.getInstance().getContext().getPackageName() + File.separator;

    public String dwonPath = Environment.getExternalStorageDirectory()
            + File.separator + BasicsFrame.getInstance().getContext().getPackageName() + File.separator + "download" + File.separator;
}
