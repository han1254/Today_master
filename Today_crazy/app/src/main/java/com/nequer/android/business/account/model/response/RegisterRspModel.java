package com.nequer.android.business.account.model.response;

import com.nequer.android.base.mvp.model.BaseBean;

public class RegisterRspModel  {

    /**
     * code : 0
     * data : 88
     */

    private int code;
    private int data;
    private String message;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
