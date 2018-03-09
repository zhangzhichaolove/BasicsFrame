package com.peak.chao.basicsframe.mvp;

import android.content.Context;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Chao  2018/3/9 on 10:53
 * description
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    protected Context mContext;
    protected CompositeDisposable disposable;
    protected WeakReference<V> mView;

    @Override
    public V getView() {
        return mView.get();
    }

    @Override
    public void attachView(V view) {
        this.mView = new WeakReference<V>(view);
        this.mContext = view.getContext();
        this.disposable = view.getDisposables();
    }


    @Override
    public void onDestroy() {
        mContext = null;
        if (disposable != null) {
            disposable.dispose();
            disposable.clear();
            disposable = null;
        }
        if (mView != null) {
            mView.clear();
            mView = null;
        }
    }
}