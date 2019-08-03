package com.nequer.android.business.square.mvp.model;

import com.nequer.android.base.mvp.model.BaseModel;
import com.nequer.android.business.square.mvp.presenter.SquarePresenter;
import com.nequer.android.network.NetWorkFactory;
import com.nequer.android.network.response.RspCallback;
import com.neuqer.android.network.response.ApiResponse;

import java.util.List;

public class SquareRecommendTest extends BaseModel {

    private SquareRecommendTest(){

    }

    private static class SquareRecommendTestHolder{
        private static final SquareRecommendTest SQUARERECOMMEND_INSTANCE = new SquareRecommendTest();
    }

    public SquareRecommendTest getSquareRecommendTest(){
        return  SquareRecommendTestHolder.SQUARERECOMMEND_INSTANCE;
    }

    public static void getMostRecommendTest(SquarePresenter presenter){
        NetWorkFactory
                .getApiService()
                .getRecommend()
                .enqueue(new RspCallback<ApiResponse<List<SquareItem>>>() {
                    @Override
                    public void onSuccess(ApiResponse<List<SquareItem>> data) {
                        presenter.getRecommendSucceed(data.getData());
                    }

                    @Override
                    public void onFailed(Throwable throwable) {

                    }
                });
    }

}
