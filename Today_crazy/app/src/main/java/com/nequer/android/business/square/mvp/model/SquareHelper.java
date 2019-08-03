package com.nequer.android.business.square.mvp.model;

import android.util.Log;

import com.nequer.android.base.mvp.model.BaseModel;
import com.nequer.android.business.detail.mvp.model.DetailModel;
import com.nequer.android.business.square.mvp.presenter.SquarePresenter;
import com.nequer.android.network.NetWorkFactory;
import com.nequer.android.network.response.RspCallback;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.network.response.ApiResponse;

import java.util.List;

public class SquareHelper extends BaseModel {
    private SquareHelper(){

    };

    private static class SquareHelperHolder{
        private static final SquareHelper INSTANCE_SQUARE = new SquareHelper();
    }

    public SquareHelper getSquareHelper(){
        return SquareHelperHolder.INSTANCE_SQUARE;
    }

    public static void getMostRecommend(SquarePresenter presenter){
        NetWorkFactory
                .getApiService()
                .getRecommend()
                .enqueue(new RspCallback<ApiResponse<List<SquareItem>>>() {
                    @Override
                    public void onSuccess(ApiResponse<List<SquareItem>> data) {
                        presenter.getRecommendSucceed(data.getData());
                    }

                    @Override
                    public void onFailed(Throwable t) {
                        presenter.getRecommendFailed();
                    }
                });
    }

    public static void getAllCalendar(int page,SquarePresenter presenter){

        NetWorkFactory
                .getApiService()
                .getSquare(page)
                .enqueue(new RspCallback<ApiResponse<List<SquareItem>>>() {
                    @Override
                    public void onSuccess(ApiResponse<List<SquareItem>> data) {
                        presenter.getSquareSucceed(data.getData());
                        //presenter.getRecommendSucceed(data.getData());
                    }

                    @Override
                    public void onFailed(Throwable t) {

                    }
                });
    }



}
