package com.nequer.android.business.manage.mvp.presenter;

import com.nequer.android.base.mvp.presenter.BasePresenter;
import com.nequer.android.business.manage.iconract.IManageContract;
import com.nequer.android.business.manage.mvp.model.ManagerHelper;
import com.nequer.android.business.manage.mvp.model.MyCreateModel;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.nequer.android.business.subscribe.mvp.model.MinModelHelper;

import java.util.List;

public class ManagerPresenter extends BasePresenter<IManageContract.View> implements IManageContract.Presenter {
    @Override
    public void getCreate() {

        ManagerHelper.getManagerHelper().getMyCreate(this);
    }

    @Override
    public void getSubscribe() {

        ManagerHelper.getManagerHelper().getMySubscribe(this);

    }

    public void onGetCreate(List<MyCreateModel> list){
        mView.onGetCreateSucceed(list);
    }

    public void onGetSubscribe(List<CalendarModel> list){mView.onGetSubscribeSucceed(list);}
}
