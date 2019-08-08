package com.nequer.android.business.manage.iconract;

import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.base.mvp.presenter.BasePresenter;
import com.nequer.android.business.manage.mvp.model.ToCreateCalendarModel;

public interface IStatus {
    interface View extends IBaseContract.IBaseView{
        void onUpLoadPicsSucceed(String url);
        void onCreateSucceed(int id);
    }

    interface Presenter extends IBaseContract.IBasePresenter{
        void upLoadPics(String load);
        void toCreateCalendar(ToCreateCalendarModel model);
    }
}
