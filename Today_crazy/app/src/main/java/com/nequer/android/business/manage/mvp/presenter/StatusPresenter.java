package com.nequer.android.business.manage.mvp.presenter;

import com.nequer.android.base.mvp.presenter.BasePresenter;
import com.nequer.android.business.manage.iconract.IStatus;
import com.nequer.android.business.manage.mvp.model.ManagerHelper;
import com.nequer.android.business.manage.mvp.model.ToCreateCalendarModel;

public class StatusPresenter extends BasePresenter<IStatus.View> implements IStatus.Presenter{
    @Override
    public void upLoadPics(String load) {
        ManagerHelper.getManagerHelper().upLoadPics(load,this);
    }

    @Override
    public void toCreateCalendar(ToCreateCalendarModel model) {

        ManagerHelper.getManagerHelper().toCreateCalendar(model,this);
    }

    public void upLoadSucceed(String url){
        mView.onUpLoadPicsSucceed(url);
    }

    public void upLoadFailed(){

    }

    public void onCreateSucceed(Long id){
        int Id = id.intValue();
        mView.onCreateSucceed(Id);
    }
}
