package com;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.retrofit.ApiService;
import com.squareup.okhttp.OkHttpClient;
import com.utils.SSLContextUtil;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Administrator on 2016/6/6.
 */
public class DemoApp extends Application {

    private static ApiService _api;
    private static DemoApp _instance;

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;

        initApiService();


    }

    /**
     * apiservice 初始化
     */
//    private void initApiService(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(HttpConfig.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())         //配置转化库，默认是Gson
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //配置回调库，采用RxJava
//                .build();
//        _api = retrofit.create(ApiService.class);
//    }
    private void initApiService(){
        //添加https
        OkHttpClient okHttpClient = new OkHttpClient();//https 证书
        okHttpClient.setSslSocketFactory(SSLContextUtil.getSSLContext().getSocketFactory());//

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())         //配置转化库，默认是Gson
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //配置回调库，采用RxJava
                .client(okHttpClient)
                .build();
        _api = retrofit.create(ApiService.class);
    }

    public static ApiService getApi() {
        return _api;
    }

    public static Application getInstance() {
        return _instance;
    }

    /**
     * toast
     */
    public static void toast(@NonNull CharSequence text) {
        Toast.makeText(_instance, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * toast
     */
    public static void toast(@StringRes int stringRes) {
        Toast.makeText(_instance, stringRes, Toast.LENGTH_SHORT).show();
    }
}
