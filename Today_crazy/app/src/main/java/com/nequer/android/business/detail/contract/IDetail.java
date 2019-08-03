package com.nequer.android.business.detail.contract;

import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.business.detail.mvp.model.DetailModel;

import java.util.List;

public interface IDetail {
    interface Presenter extends IBaseContract.IBasePresenter{
        void getDetail(int detailId);
        void getComment(int detailId, int page);
        void getDetailFailed();
        void getCommentFailed();
        void toSubscribe(int calendarId);
        void unSubscribe(int calendarId);

    }

    interface View extends IBaseContract.IBaseView{
        void onDetailSucceed(DetailModel detailModel);
        void onCommendSucceed();
        void onDetailFailed();
        void onSubscribeSucceed();
        void onSubscribeFailed();
        void onUnSubscribeSucceed();
        void onUnSubscribeFailed();
    }

}
