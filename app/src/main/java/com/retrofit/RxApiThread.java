package com.retrofit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/6/6.
 * 从工作线程返回主线程
 */
public final class RxApiThread {

    static Observable.Transformer schedulersTransformer = new Observable.Transformer(){

        @Override
        public Object call(Object o) {
            return ((Observable) o).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };

    static Observable.Transformer main = new Observable.Transformer(){

        @Override
        public Object call(Object o) {
            return ((Observable) o).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };

    @SuppressWarnings("unchecked")
    public static <T> Observable.Transformer<T,T> convert(){
        return schedulersTransformer;
    }

    @SuppressWarnings("unchecked")
    public static <T> Observable.Transformer<T,T> main(){
        return main;
    }

}
