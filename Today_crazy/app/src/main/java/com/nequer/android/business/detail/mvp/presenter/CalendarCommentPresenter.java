package com.nequer.android.business.detail.mvp.presenter;

import com.nequer.android.base.mvp.presenter.BasePresenter;
import com.nequer.android.business.detail.contract.ICommentFragmentContract;
import com.nequer.android.business.detail.mvp.model.DetailCommentModel;
import com.nequer.android.business.detail.mvp.model.DetailHelper;

import java.util.List;

public class CalendarCommentPresenter extends BasePresenter<ICommentFragmentContract.ICommentView> implements ICommentFragmentContract.ICommentPresenter{
    @Override
    public void getComment(int id, int page) {
        DetailHelper.getDetailHelper().getCalendarComment(this,id,page);
    }

    @Override
    public void onGetCommentSucceed(List<DetailCommentModel> list) {
        if(list != null){
            mView.getCommentSuccess(list);
        }else{
            mView.toLastPage();
        }
    }

    @Override
    public void onGetCommentFailed(Throwable t) {

    }

    @Override
    public void sendComment(String content, int calendarId) {
        DetailHelper.getDetailHelper().sendComment(this,calendarId,content);
    }

    public void onSendCommentSucceed(){
        mView.onSendCommentSucceed();
    }

    public void onSendCommentFailed(Throwable t){

    }
}
