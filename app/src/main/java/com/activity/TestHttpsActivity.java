package com.activity;

import android.view.View;
import android.widget.Button;

import com.base.BaseActivity;
import com.retrofit.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/12.
 */
public class TestHttpsActivity  extends BaseActivity {

    @BindView(R.id.btn_retrofit_rxjava_https)
    Button btn_retrofit_rxjava_https;

    @BindView(R.id.btn_retrofit_rxjava_https_no)
    Button btn_retrofit_rxjava_https_no;

    @Override
    protected int inflateLayoutId() {
        return R.layout.test_retrofit_rxjava_post_https;
    }

    @Override
    protected void initViews() {



    }

    @OnClick({R.id.btn_retrofit_rxjava_https,R.id.btn_retrofit_rxjava_https_no})
    public void buttonClick(View view){
        switch (view.getId()){
            case R.id.btn_retrofit_rxjava_https:

                break;
            case R.id.btn_retrofit_rxjava_https_no:

                break;
            default:
        }
    }

    public void requestHttpsNeedSSL(){



//        DemoApp.getApi().getLogin("","","").compose()

    }


}


