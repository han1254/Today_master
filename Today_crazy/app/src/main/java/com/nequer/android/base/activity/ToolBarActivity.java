package com.nequer.android.base.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.neuqer.android.R;


public abstract class ToolBarActivity extends BaseActivity {

    private Toolbar mToolbar;



    /**
     * 初始化Toolbar.
     */
    private void initToolbar(View root) {
        if (!toolbarEnable()) {
            return;
        }
        mToolbar = root.findViewById(R.id.toolbar_root);
        mToolbar.setVisibility(setToolBar());
        mToolbar.setTitle(getActivityTitle());
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null && backButtonEnable()) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    protected boolean toolbarEnable() {
        return true;
    }


    protected int setToolBar() {
        return View.VISIBLE;
    }

    protected String getActivityTitle() {
        return "";
    }

    protected boolean backButtonEnable() {
        return true;
    }

    protected void initView(){

    }

}
