package com.peak.chao.basicsframe.mvp;

/**
 * Created by Chao  2018/3/9 on 10:52
 * description
 */

public interface MvpPresenter<V extends MvpView> {

    V getView();

    void attachView(V view);

    void onDestroy();
}
