package com.nequer.android.business.square.mvp.presenter;

import com.nequer.android.base.mvp.presenter.BasePresenter;
import com.nequer.android.business.square.contract.ISquareContract;
import com.nequer.android.business.square.mvp.model.SquareHelper;
import com.nequer.android.business.square.mvp.model.SquareItem;
import com.nequer.android.business.square.mvp.model.SquareRecommendTest;

import java.util.List;

public class SquarePresenter extends BasePresenter<ISquareContract.View> implements ISquareContract.Presenter{
    @Override
    public void getRecommend() {

        SquareHelper.getMostRecommend(this);

    }

    @Override
    public void getNormal(int page) {

        SquareHelper.getAllCalendar(page,this);
    }



    public void getRecommendSucceed(List<SquareItem> list){

        mView.onRecommendSucceed(list);
    }

    public void getSquareSucceed(List<SquareItem> list){

        if(list.isEmpty()){
            mView.getLastPage();
        }else{
            mView.onNormalSucceed(list);
        }

    }

    public void getSquareFailed(){


    }

    public void getRecommendFailed(){
        mView.onRecommendFailed();
    }


}
