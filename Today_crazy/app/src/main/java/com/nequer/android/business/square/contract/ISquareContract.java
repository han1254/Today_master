package com.nequer.android.business.square.contract;

import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.business.square.mvp.model.SquareItem;

import java.util.List;

public interface ISquareContract {
    interface  View extends IBaseContract.IBaseView{
        void onRecommendSucceed(List<SquareItem> list);
        void onNormalSucceed(List<SquareItem> list);
        void onRecommendFailed();
        void onNormalFailed();
        void getLastPage();
    }

    interface Presenter extends IBaseContract.IBasePresenter{
        void getRecommend();
        void getNormal(int page);

    }


}
