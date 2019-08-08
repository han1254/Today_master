package com.nequer.android.business.manage.iconract;

import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;

import java.util.List;

public interface IMySubscribeContract {
    interface  View extends IBaseContract.IBaseView{
        void onGetSubscribeSucceed(List<CalendarModel> list);
        void onGetSubscribeFailed();

        void onUnSubscribeSucceed();

    }

    interface Presenter extends IBaseContract.IBasePresenter{
        void getSubscribe();
        void unSubscribe(int id);
    }
}
