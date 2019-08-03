package com.nequer.android.business.account.model;
import android.util.Log;

import com.nequer.android.base.mvp.model.BaseModel;
import com.nequer.android.business.account.model.request.LoginReqModel;
import com.nequer.android.business.account.model.request.RegisterReqModel;
import com.nequer.android.business.account.model.response.LoginResponseModel;
import com.nequer.android.business.account.model.response.LoginRspModel;
import com.nequer.android.business.account.presenter.LoginActivityPresenter;
import com.nequer.android.business.account.presenter.RegisterActivityPresenter;
import com.nequer.android.network.NetWorkFactory;
import com.nequer.android.network.response.RspCallback;
import com.neuqer.android.network.response.ApiResponse;

public class AccountHelper extends BaseModel {
    private AccountHelper(){

    }

    private static class AccountHelperHolder{
        private static final AccountHelper INSTANCE = new AccountHelper();
    }

    public AccountHelper getAccountHelper(){
        return AccountHelperHolder.INSTANCE;
    }




    public static void register (RegisterActivityPresenter presenter, RegisterReqModel reqModel){

        Log.d("Register","im here");

        NetWorkFactory
                .getApiService()
                .register(reqModel)
                .enqueue(new RspCallback<ApiResponse<Long>>() {
                    @Override
                    public void onSuccess(ApiResponse<Long> data) {
                        Log.d("success","success");
                        presenter.onSuccess(data);
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }


    public static void login(LoginActivityPresenter presenter, LoginReqModel reqModel) {
        NetWorkFactory
                .getApiService()
                .login(reqModel)
                .enqueue(new RspCallback<LoginResponseModel>() {
                    @Override
                    public void onSuccess(LoginResponseModel data) {
                        presenter.onSuccess(data);
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }


}
