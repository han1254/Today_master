package com.nequer.android.business.subscribe.mvp.model;

import com.nequer.android.base.mvp.model.BaseModel;
import com.nequer.android.business.subscribe.mvp.presenter.SubcribePresenter;
import com.nequer.android.network.NetWorkFactory;
import com.nequer.android.network.response.RspCallback;
import com.neuqer.android.network.response.ApiResponse;

import java.util.List;

public class MinModelHelper extends BaseModel {

    private MinModelHelper(){

    }

    private static class MinModelHelperHolder{
        private static final MinModelHelper INSTANCE_MIN = new MinModelHelper();
    }

    public MinModelHelper getMinModelHelper(){
        return MinModelHelperHolder.INSTANCE_MIN;
    }

    public static void getSubscribed(SubcribePresenter presenter){
        NetWorkFactory
                .getApiService()
                .getSubscribed()
                .enqueue(new RspCallback<ApiResponse<List<CalendarModel>>>() {
                    @Override
                    public void onSuccess(ApiResponse<List<CalendarModel>> data) {

                        presenter.onCalendarSuccess(data.getData());
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }
}
