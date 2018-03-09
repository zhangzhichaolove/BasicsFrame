package com.peak.chao.basicsframe.mvp;

import android.content.Context;

import com.peak.chao.basicsframe.base.BaseActivity;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Chao  2018/3/9 on 10:52
 * description
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity implements MvpView {
    protected P presenter;
    protected CompositeDisposable disposables;

    public abstract P createPresenter();

    @Override
    protected void initPresenter() {
        disposables = new CompositeDisposable();
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public CompositeDisposable getDisposables() {
        return disposables;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroy();
            presenter = null;
        }
    }
}
