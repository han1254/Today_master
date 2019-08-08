package com.nequer.android.business.manage.mvp.model;

import com.nequer.android.App;
import com.nequer.android.business.manage.mvp.presenter.ManagerPresenter;
import com.nequer.android.business.manage.mvp.presenter.MyCreatePresenter;
import com.nequer.android.business.manage.mvp.presenter.MySubscribePresenter;
import com.nequer.android.business.manage.mvp.presenter.StatusPresenter;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.nequer.android.network.NetWorkFactory;
import com.nequer.android.network.response.RspCallback;
import com.neuqer.android.network.response.ApiResponse;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;

import org.json.JSONObject;

import java.util.List;
import java.util.UUID;

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

    public void unSubscribe(MySubscribePresenter presenter, int id){
        NetWorkFactory.getApiService()
                .unSubscribeCalendar(id)
                .enqueue(new RspCallback<ApiResponse<Void>>() {
                    @Override
                    public void onSuccess(ApiResponse<Void> data) {
                        presenter.onUnSubscribeSucceed();
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }


    //通过七牛获取图片url地址
    public void upLoadPics(String path, StatusPresenter presenter){
        NetWorkFactory
                .getApiService()
                .getPicsToken()
                .enqueue(new RspCallback<ApiResponse<String>>() {
                    @Override
                    public void onSuccess(ApiResponse<String> data) {
                        App.getInstance().getUploadManager().put(path, UUID.randomUUID().toString(), data.getData(), (UpCompletionHandler) (key, info, response) -> {
                            if (info.isOK()){
                                presenter.upLoadSucceed(key);
                            }else{

                            }
                        },null);
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }


    public void toCreateCalendar(ToCreateCalendarModel model,StatusPresenter presenter){
        NetWorkFactory
                .getApiService()
                .toCreateCalendar(model)
                .enqueue(new RspCallback<ApiResponse<Long>>() {
                    @Override
                    public void onSuccess(ApiResponse<Long> data) {
                        presenter.onCreateSucceed(data.getData());
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }


    public void deleteCalendar(int id, MyCreatePresenter presenter){
        NetWorkFactory.getApiService()
                .deleteCalendar(id)
                .enqueue(new RspCallback<ApiResponse<Long>>() {
                    @Override
                    public void onSuccess(ApiResponse<Long> data) {
                        presenter.onDeleteSucceed(data.getData());
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });

    }

}
