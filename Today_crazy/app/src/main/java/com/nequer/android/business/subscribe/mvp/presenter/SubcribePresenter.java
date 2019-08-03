package com.nequer.android.business.subscribe.mvp.presenter;

import android.content.SharedPreferences;
import android.widget.TextView;

import com.nequer.android.base.mvp.presenter.BasePresenter;
import com.nequer.android.business.account.model.UserInfo;
import com.nequer.android.business.subscribe.contract.SubscribeContract;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.nequer.android.business.subscribe.mvp.model.MinModelHelper;
import com.nequer.android.utils.CacheUtil;

import java.util.ArrayList;
import java.util.List;

public class SubcribePresenter extends BasePresenter<SubscribeContract.View> implements SubscribeContract.Presenter{

    @Override
    public void exit() {

    }

    @Override
    public void getCalendar() {
        MinModelHelper.getSubscribed(this);
    }

    public void onCalendarSuccess(List<CalendarModel> calendarModelList){

        SharedPreferences sp = CacheUtil.getSP();
        UserInfo userInfo = new UserInfo();
        userInfo.setCalendarList(calendarModelList);
        userInfo.saveUserSubcribedCalendar();

        mView.onSubscribedCalendarSuccess(calendarModelList);
    }
}
