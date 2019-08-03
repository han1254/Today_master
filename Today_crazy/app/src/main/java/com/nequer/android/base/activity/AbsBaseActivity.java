package com.nequer.android.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

public abstract class AbsBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        loadata();
        initValue();

        initView();

    }



    protected abstract int getLayoutRes();

    protected abstract void initView();

    protected abstract void initValue();

    protected abstract void loadata();
}
