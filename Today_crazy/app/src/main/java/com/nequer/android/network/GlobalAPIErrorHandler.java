package com.nequer.android.network;

import com.nequer.android.Application;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.network.exception.ApiException;

public class GlobalAPIErrorHandler {

    public static void handler ( int code ) {
        switch ( code ) {
            case 200 :
                ToastUtil.showToast("200");
            case 400 : ToastUtil.showToast("400");
            case 500 : ToastUtil.showToast("服务器崩了");
            default:
                ToastUtil.showToast("请求不被允许");
                break;
        }
    }

    public  static void handler (ApiException e ) {
        switch ( e.getCode() ) {
            default :
                ToastUtil.showToast(e.getMsg());
                break;
        }
    }
}
