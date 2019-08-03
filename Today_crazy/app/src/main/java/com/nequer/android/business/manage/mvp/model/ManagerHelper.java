package com.nequer.android.business.manage.mvp.model;

import com.nequer.android.business.manage.mvp.presenter.ManagerPresenter;
import com.nequer.android.business.manage.mvp.presenter.MyCreatePresenter;
import com.nequer.android.business.manage.mvp.presenter.MySubscribePresenter;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.nequer.android.network.NetWorkFactory;
import com.nequer.android.network.response.RspCallback;
import com.neuqer.android.network.response.ApiResponse;

import java.util.List;

public class ManagerHelper {
    private ManagerHelper(){}

    private static class ManagerHelperHoler{
        private static final ManagerHelper INSTANCE = new ManagerHelper();
    }

    public static ManagerHelper getManagerHelper(){
        return ManagerHelperHoler.INSTANCE;
    }

    public void getMyCreate(MyCreatePresenter presenter){
        NetWorkFactory.getApiService()
                .getMyCreateCalendar()
                .enqueue(new RspCallback<ApiResponse<List<MyCreateModel>>>() {
                    @Override
                    public void onSuccess(ApiResponse<List<MyCreateModel>> data) {
                        presenter.getCreateSucceed(data.getData());
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }

    public void getMySubscribe(MySubscribePresenter presenter){
        NetWorkFactory.getApiService()
                .getSubscribed()
                .enqueue(new RspCallback<ApiResponse<List<CalendarModel>>>() {
                    @Override
                    public void onSuccess(ApiResponse<List<CalendarModel>> data) {
                       presenter.onSucceed(data.getData());
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }

    public void getMySubscribe(ManagerPresenter presenter){
        NetWorkFactory.getApiService()
                .getSubscribed().enqueue(new RspCallback<ApiResponse<List<CalendarModel>>>() {
            @Override
            public void onSuccess(ApiResponse<List<CalendarModel>> data) {
                presenter.onGetSubscribe(data.getData());
            }

            @Override
            public void onFailed(Throwable t) {

            }
        });
    }

    public void getMyCreate(ManagerPresenter presenter){
        NetWorkFactory.getApiService()
                .getMyCreateCalendar()
                .enqueue(new RspCallback<ApiResponse<List<MyCreateModel>>>() {
                    @Override
                    public void onSuccess(ApiResponse<List<MyCreateModel>> data) {
                        presenter.onGetCreate(data.getData());
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }
}
