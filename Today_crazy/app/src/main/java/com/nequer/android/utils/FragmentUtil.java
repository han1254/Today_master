package com.nequer.android.utils;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.nequer.android.base.activity.AbsBaseActivity;
import com.nequer.android.base.activity.BaseActivity;

public class FragmentUtil {
    /**
     * 添加Fragment
     */
    public static void add(AbsBaseActivity context, int viewId, Fragment fragment, @Nullable String tag) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .add(viewId, fragment, tag)
                .commit();
    }

    /**
     * 替换Fragment
     */
    public static void replace(AbsBaseActivity context, int viewId, Fragment fragment, @Nullable String tag) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .replace(viewId, fragment, tag)
                .commit();
    }

    /**
     * 隐藏Fragment
     */
    public static void hideFragment(AbsBaseActivity context, Fragment fragment) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .hide(fragment)
                .commit();
    }

    /**
     * 展示Fragment
     */
    public static void showFragment(AbsBaseActivity context, Fragment fragment) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .show(fragment)
                .commit();
    }
}

