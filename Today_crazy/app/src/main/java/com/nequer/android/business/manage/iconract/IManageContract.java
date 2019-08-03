package com.nequer.android.business.manage.iconract;

import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.business.manage.mvp.model.MyCreateModel;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;

import java.util.List;

public interface IManageContract {
    interface Presenter extends IBaseContract.IBasePresenter{
        void getCreate();
        void getSubscribe();
    }

    interface View extends IBaseContract.IBaseView{
        void onGetCreateSucceed(List<MyCreateModel> list);
        void onGetCreateFailed();
        void onGetSubscribeSucceed(List<CalendarModel> list);
        void onGetSubscribeFailed();
    }
}
