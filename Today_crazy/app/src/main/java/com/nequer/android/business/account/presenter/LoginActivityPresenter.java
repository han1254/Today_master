package com.nequer.android.business.account.presenter;

import android.util.Log;

import com.nequer.android.base.mvp.presenter.BasePresenter;
import com.nequer.android.business.account.contract.LoginContract;
import com.nequer.android.business.account.model.AccountHelper;
import com.nequer.android.business.account.model.UserInfo;
import com.nequer.android.business.account.model.request.LoginReqModel;
import com.nequer.android.business.account.model.response.LoginResponseModel;
import com.nequer.android.business.account.model.response.LoginRspModel;
import com.neuqer.android.network.response.ApiResponse;

public class LoginActivityPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter{
    @Override
    public void login(LoginReqModel reqModel) {

        AccountHelper.login(this,reqModel);

    }


    public void onSuccess(LoginResponseModel responseModel){

        UserInfo userInfo = new UserInfo();
        userInfo.setName(responseModel.getData().getUser().getName());
        userInfo.setAvatar(responseModel.getData().getUser().getAvatar());
        userInfo.setSignature(responseModel.getData().getUser().getSignature());
        userInfo.setToken(responseModel.getData().getToken());
        userInfo.saveUserInfo();

        mView.loginSuccess(responseModel);



    }
}
