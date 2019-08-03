package com.nequer.android.business.account.presenter;

import android.util.Log;

import com.nequer.android.App;
import com.nequer.android.Application;
import com.nequer.android.base.mvp.presenter.BasePresenter;
import com.nequer.android.business.account.contract.RegisterContract;
import com.nequer.android.business.account.model.AccountHelper;
import com.nequer.android.business.account.model.request.RegisterReqModel;
import com.nequer.android.business.account.model.response.RegisterRspModel;
import com.nequer.android.business.account.view.RegisterActivity;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.network.response.ApiResponse;

public class RegisterActivityPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter {
//    private RegisterContract.View mView;
//    public RegisterActivityPresenter(RegisterActivity mView) {
//        this.mView = mView;
//    }

    @Override
    public void register(RegisterReqModel registerReqModel){
        /*if(registerReqModel.getPassword().length() < 6 || registerReqModel.getPassword().length() > 20) {
            ToastUtil.showToast("密码应多于6位且少于20位");
        } else if ( registerReqModel.getConfirmPassword() != registerReqModel.getPassword()) {
            ToastUtil.showToast("两次密码不一致");
        }*/
        AccountHelper.register(this,registerReqModel);
    }

    public void onSuccess(ApiResponse<Long> data){
        Log.d("prestener", "here");
        if (mView == null) {
            Log.d("prestener", "mView is null");
        }
        if (data.getData() == null) {
            Log.d("prestener", "data is null");
        } else {
            Log.d("prestener", data.getData().toString());
        }
        mView.registerSuccess(data.getData());

    }

    public void onFalied (){
        mView.registerFailed();
    }
}