package com.nequer.android;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;


import com.nequer.android.business.account.model.UserInfo;
import com.nequer.android.business.account.view.MainActivity;
import com.nequer.android.utils.CacheUtil;
import com.nequer.android.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangZhaoxin.
 * @since 2019/5/3 17:15.
 * email yangzhaoxin@hrsoft.net.
 */

public class App extends Application {

    private static final long EXIT_TIME = 2000;

    private static long sTimeMillis = 0;

    private static App sInstance;

    private static List<Activity> sActivityList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        registerActivityLifecycleCallbacks(getActivityLifecycleCallbacks());
    }

    public static App getInstance() {
        return sInstance;
    }

    public ActivityLifecycleCallbacks getActivityLifecycleCallbacks() {
        return new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                sActivityList.add(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                sActivityList.remove(activity);
            }
        };
    }

    /**
     * 清除所有的Activity
     */
    public void removeAllActivity() {
        for (Activity activity : sActivityList) {
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    /**
     * 双击退出应用
     */
    public void exitAppWithTwiceClick() {
        // 获取当前时间戳
        long currentTime = System.currentTimeMillis();
        if ((currentTime - sTimeMillis) > EXIT_TIME) {
            ToastUtil.showToast("再次点击退出应用");
            sTimeMillis = currentTime;
        } else {
            removeAllActivity();
        }
    }

    /**
     * 退出应用
     */
    public void exitApp() {
        removeAllActivity();
    }

    /**
     * 切换账户
     */
    public void changeAccount() {
        removeAllActivity();
        CacheUtil.clear();
    }

    /**
     * 退出登陆
     */
    public void exitLogin() {
        UserInfo userInfo = new UserInfo();
        userInfo.clearUserInfo();
        removeAllActivity();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}