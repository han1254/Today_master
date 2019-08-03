package com.nequer.android.business.subscribe.contract;

import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;

import java.util.List;

public interface SubscribeContract {

    interface Presenter extends IBaseContract.IBasePresenter{
        void exit();
        void getCalendar();
    }

    interface View extends IBaseContract.IBaseView{

        void onSubscribedCalendarSuccess(List<CalendarModel> calendarModelList);
    }
}
