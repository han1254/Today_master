package com.nequer.android.business.detail.mvp.model;

import com.nequer.android.business.detail.mvp.presenter.CalendarCommentPresenter;
import com.nequer.android.business.detail.mvp.presenter.DetailPresenter;
import com.nequer.android.network.NetWorkFactory;
import com.nequer.android.network.response.RspCallback;
import com.neuqer.android.network.response.ApiResponse;

import java.util.List;

public class DetailHelper {
    private DetailHelper(){

    }

    private static class DetailHelperHolder{
        private static final DetailHelper DETAIL_HELPER = new DetailHelper();
    }

    public static DetailHelper getDetailHelper(){
        return DetailHelperHolder.DETAIL_HELPER;
    }

    public static void getCalendarDetail(DetailPresenter presenter, int detailId){
        NetWorkFactory
                .getApiService()
                .getCalendarDetail(detailId)
                .enqueue(new RspCallback<ApiResponse<DetailModel>>() {
                    @Override
                    public void onSuccess(ApiResponse<DetailModel> data) {

                        presenter.onGetDetailSucceed(data.getData());
                    }

                    @Override
                    public void onFailed(Throwable t) {

                        presenter.onGetDetailFailed();
                    }
                });
    }

    public void getCalendarComment(CalendarCommentPresenter presenter, int detailId, int page){
        NetWorkFactory
                .getApiService()
                .getCalendarComment(detailId,page)
               .enqueue(new RspCallback<ApiResponse<List<DetailCommentModel>>>() {
                   @Override
                   public void onSuccess(ApiResponse<List<DetailCommentModel>> data) {
                       presenter.onGetCommentSucceed(data.getData());
                   }

                   @Override
                   public void onFailed(Throwable t) {

                       presenter.onGetCommentFailed(t);
                   }
               });
    }


    public void toSubscribe(DetailPresenter presenter, int detailId){
        NetWorkFactory
                .getApiService()
                .subscribeCalendar(detailId)
                .enqueue(new RspCallback<ApiResponse<Void>>() {
                    @Override
                    public void onSuccess(ApiResponse<Void> data) {
                        presenter.onSubscribeSucceed();
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }

    public void unSubscribe(DetailPresenter presenter, int calendarId){
        NetWorkFactory
                .getApiService()
                .unSubscribeCalendar(calendarId)
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


    public void sendComment(CalendarCommentPresenter presenter, int calendarId, String content){
        NetWorkFactory.getApiService()
                .sendComment(calendarId,new DetailCommentModel(content))
                .enqueue(new RspCallback<ApiResponse<Void>>() {
                    @Override
                    public void onSuccess(ApiResponse<Void> data) {
                        presenter.onSendCommentSucceed();
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }





}
