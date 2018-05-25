package com.wu.safe.apermission.app.acitvity;

import android.os.Bundle;

import com.smart.base.app.activity.BaseAppCompatActivity;
import com.smart.base.app.event.RxBusHelper;

import butterknife.ButterKnife;

public abstract class PermissBaseCompatActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        ButterKnife.bind(this);
    }

    protected abstract int setContentView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBusHelper.unSubscribe(this);
    }
}
