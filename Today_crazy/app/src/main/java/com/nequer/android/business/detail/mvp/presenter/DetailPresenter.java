package com.nequer.android.business.detail.mvp.presenter;

import com.nequer.android.base.mvp.presenter.BasePresenter;
import com.nequer.android.business.detail.contract.IDetail;
import com.nequer.android.business.detail.mvp.model.DetailCommentModel;
import com.nequer.android.business.detail.mvp.model.DetailHelper;
import com.nequer.android.business.detail.mvp.model.DetailModel;

import java.util.List;

public class DetailPresenter extends BasePresenter<IDetail.View> implements IDetail.Presenter{
    @Override
    public void getDetail(int detailId) {

        DetailHelper.getCalendarDetail(this,detailId);
    }

    @Override
    public void getComment(int detailId, int page) {

        //DetailHelper.getDetailHelper().getCalendarComment(this,detailId,page);
    }

    @Override
    public void getDetailFailed() {

    }

    @Override
    public void getCommentFailed() {

    }

    @Override
    public void toSubscribe(int calendarId) {
        DetailHelper.getDetailHelper().toSubscribe(this,calendarId);
    }

    @Override
    public void unSubscribe(int calendarId) {
        DetailHelper.getDetailHelper().unSubscribe(this,calendarId);
    }

    public void onGetDetailSucceed(DetailModel detailModel){
        mView.onDetailSucceed(detailModel);
    }

    public void onGetDetailFailed(){
        mView.onDetailFailed();
    }

    public void onGetCommentSucceed(List<DetailCommentModel> list){

    }

    public void onSubscribeSucceed(){
        mView.onSubscribeSucceed();
    }

    public void onSubscribeFailed(){
        mView.onSubscribeFailed();
    }


    public void onUnSubscribeSucceed(){
        mView.onUnSubscribeSucceed();
    }




}
