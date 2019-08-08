package com.nequer.android;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;


import com.nequer.android.business.account.model.UserInfo;
import com.nequer.android.business.account.view.MainActivity;
import com.nequer.android.common.Config;
import com.nequer.android.utils.CacheUtil;
import com.nequer.android.utils.ToastUtil;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UploadManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author YangZhaoxin.
 * @since 2019/5/3 17:15.
 * email yangzhaoxin@hrsoft.net.
 */

public class App extends Application {

    private String cachePath;

    private UploadManager uploadManager;

    private static final long EXIT_TIME = 2000;

    private static long sTimeMillis = 0;

    private static App sInstance;

    private static List<Activity> sActivityList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        cachePath = Objects.requireNonNull(getExternalCacheDir()).getAbsolutePath();
        registerActivityLifecycleCallbacks(getActivityLifecycleCallbacks());

        Configuration config = new Configuration.Builder()
                .chunkSize(512 * 1024)        // 分片上传时，每片的大小。 默认256K
                .putThreshhold(1024 * 1024)   // 启用分片上传阀值。默认512K
                .connectTimeout(10)           // 链接超时。默认10秒
                .useHttps(true)               // 是否使用https上传域名
                .responseTimeout(60)          // 服务器响应超时。默认60秒
                .zone(FixedZone.zone1)        // 设置区域，指定不同区域的上传域名、备用域名、备用IP。
                .build();

        uploadManager = new UploadManager(config);
    }

    public static App getInstance() {
        return sInstance;
    }

    public UploadManager getUploadManager(){
        return uploadManager;
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

    public String getCachePath(){
        return cachePath;
    }

}
