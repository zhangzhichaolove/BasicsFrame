package com.peak.chao.basicsframe.net;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Chao  2018/3/9 on 11:48
 * description
 */

public class ApiRequest {

    /**
     * 源请求
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public synchronized static <T> void source(Observable<T> observable, Observer<T> observer) {
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    /**
     * 不含有DTO的请求
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public synchronized static <T extends HttpResult> void obtain(Observable<T> observable, Observer<T> observer) {
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    /**
     * 含有DTO的请求(map操作符不能返回null，内部会抛出异常，导致回调失效
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public synchronized static <T extends HttpResultDTO<R>, R extends Mapper<M>, M> void request(Observable<T> observable, Observer<M> observer) {
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .map(new Function<T, M>() {
                    @Override
                    public M apply(@NonNull T t) throws Exception {
                        if (t == null || t.getData() == null) {
                            return null;
                        } else if (t.getCode() != 200) {
                            new ApiException(t.getCode(), new Throwable(t.getMsg()));
                        }
                        return t.getData().transformation();
                    }
                })
                .subscribe(observer);
    }

}
