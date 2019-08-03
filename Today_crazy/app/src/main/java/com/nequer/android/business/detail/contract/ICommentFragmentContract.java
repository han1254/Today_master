package com.nequer.android.business.detail.contract;

import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.business.detail.mvp.model.DetailCommentModel;

import java.util.List;

public interface ICommentFragmentContract {

    interface ICommentPresenter extends IBaseContract.IBasePresenter{
        void getComment(int id,int page);
        void onGetCommentSucceed(List<DetailCommentModel> list);
        void onGetCommentFailed(Throwable t);
        void sendComment(String content, int calendarId);
    }

    interface ICommentView extends IBaseContract.IBaseView{
        void getCommentSuccess(List<DetailCommentModel> list);

        void toLastPage();

        void onSendCommentSucceed();
        void onSendCommentFailed();
    }

}
