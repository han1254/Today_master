package com.nequer.android.business.account.contract;

import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.business.account.model.request.LoginReqModel;
import com.nequer.android.business.account.model.response.LoginResponseModel;
import com.nequer.android.business.account.model.response.LoginRspModel;
import com.nequer.android.network.response.ApiResponse;

public interface LoginContract {
    interface Presenter extends IBaseContract.IBasePresenter{
        /**
         * 登陆账户
         */
        void login(LoginReqModel reqModel);
    }


    interface View extends IBaseContract.IBaseView{
        void loginSuccess(LoginResponseModel loginResponseModel);
        void loginFailed();
    }
}
