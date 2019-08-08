package com.nequer.android.business.manage.mvp.presenter;

import com.nequer.android.base.mvp.presenter.BasePresenter;
import com.nequer.android.business.manage.iconract.IMyCreateContract;
import com.nequer.android.business.manage.mvp.model.ManagerHelper;
import com.nequer.android.business.manage.mvp.model.MyCreateModel;

import java.util.List;

public class MyCreatePresenter extends BasePresenter<IMyCreateContract.View> implements IMyCreateContract.Presenter {


    @Override
    public void getCreate() {
        ManagerHelper.getManagerHelper().getMyCreate(this);
    }

    @Override
    public void deleteCalendar(int id) {
        ManagerHelper.getManagerHelper().deleteCalendar(id,this);
    }

    public void getCreateSucceed(List<MyCreateModel> list){

        mView.onGetCreateSucceed(list);
    }

    public void getCreateFailed(){
    }

    public void onDeleteSucceed(Long data){
        mView.onDeleteSucceed(data);
    }
}
