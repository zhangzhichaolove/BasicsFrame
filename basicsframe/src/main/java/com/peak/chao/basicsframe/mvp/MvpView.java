package com.peak.chao.basicsframe.mvp;

import android.content.Context;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Chao  2018/3/9 on 10:52
 * description
 */

public interface MvpView {

    Context getContext();

    CompositeDisposable getDisposables();

}
