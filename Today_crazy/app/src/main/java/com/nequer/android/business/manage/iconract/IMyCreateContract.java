package com.nequer.android.business.manage.iconract;

import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.business.manage.mvp.model.MyCreateModel;

import java.util.List;

public interface IMyCreateContract {
    interface View extends IBaseContract.IBaseView{

        void onGetCreateSucceed(List<MyCreateModel> list);
        void onGetCreateFailed();

        void onDeleteSucceed(Long data);
    }

    interface Presenter extends IBaseContract.IBasePresenter{

        void getCreate();
        void deleteCalendar(int id);
    }
}
