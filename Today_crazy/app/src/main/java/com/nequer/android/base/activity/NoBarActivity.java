package com.nequer.android.base.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neuqer.android.R;

public class NoBarActivity extends AbsBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_no_bar;
    }

    @Override
    protected void initView() {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null ) {
            actionBar.hide();
        }
    }

    @Override
    protected void initValue() {

    }

    @Override
    protected void loadata() {

    }
}
