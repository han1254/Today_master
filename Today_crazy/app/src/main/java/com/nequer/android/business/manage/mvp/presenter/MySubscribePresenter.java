package com.nequer.android.business.manage.mvp.presenter;

import com.nequer.android.base.mvp.presenter.BasePresenter;
import com.nequer.android.business.manage.iconract.IMySubscribeContract;
import com.nequer.android.business.manage.mvp.model.ManagerHelper;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;

import java.util.List;

public class MySubscribePresenter extends BasePresenter<IMySubscribeContract.View> implements IMySubscribeContract.Presenter{
    @Override
    public void getSubscribe() {
        ManagerHelper.getManagerHelper().getMySubscribe(this);
    }

    @Override
    public void unSubscribe(int id) {
        ManagerHelper.getManagerHelper().unSubscribe(this,id);
    }

    public void onSucceed(List<CalendarModel> list){
        mView.onGetSubscribeSucceed(list);
    }

    public void onUnSubscribeSucceed(){
        mView.onUnSubscribeSucceed();
    }
}
