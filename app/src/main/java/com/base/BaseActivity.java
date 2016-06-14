package com.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.AppManager;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.utils.LogUtil;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/6/7.
 * Rxlifecycle使用详解，解决RxJava内存泄露问题
 * 基类
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    public Context mContext;

    // 是否允许全屏
    private boolean mAllowFullScreen = true;

    /**
     * 设置是否允许屏幕全屏
     */
    public void setAllowFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }

    /**
     * 查看是否允许全屏
     */
    public boolean getAllowFullScreen() {
        return mAllowFullScreen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogUtil.i("---------onCreate ");
        // 竖屏锁定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(inflateLayoutId());
        //注解绑定
        ButterKnife.bind(this);

        mContext = this;
        //
        prepare();
        //
        initViews();

        AppManager.getAppManager().addActivity(this);
    }

    protected abstract int inflateLayoutId();

    /**
     * 初始化布局前的准备工作
     */
    protected void prepare(){}

    /**
     * 初始化布局：首行需要setContentView()
     */
    protected void initViews(){}

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.i("---------onStart ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i("---------onResume ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.i("---------onPause ");
    }


    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.i("---------onStop ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.i("---------onDestroy ");

        ButterKnife.bind(this);

//        final DemoApp app = (DemoApp) getApplication();
//        app.getWatcher().watch(this);
        AppManager.getAppManager().finishActivity(this);
    }
}
