package com.nequer.android.business.square.mvp.view;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.nequer.android.base.adapter.BaseRecyclerViewAdapter;
import com.nequer.android.base.mvp.view.BasePresenterActivity;
import com.nequer.android.business.detail.mvp.view.DetailActivity;
import com.nequer.android.business.square.adapter.SquareAdapter;
import com.nequer.android.business.square.contract.ISquareContract;
import com.nequer.android.business.square.mvp.model.SquareItem;
import com.nequer.android.business.square.mvp.presenter.SquarePresenter;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;

import java.util.ArrayList;
import java.util.List;

public class SquareActivity extends BasePresenterActivity<ISquareContract.Presenter> implements ISquareContract.View, SquareAdapter.OnItemViewClickListener {


    private List<SquareItem> mRecommendList = new ArrayList<>();
    private List<SquareItem> mNormalList = new ArrayList<>();
    private SquareAdapter allAdapter;
    private SquareAdapter recommendAdapter;
    private RecyclerView mRecommendRecyclerView;
    private RecyclerView mSquareRecyclerView;
    private ImageView imageBack;
    private int page = 1;

    private boolean flag = false;

    private boolean flag2 = false;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_square;
    }

    @Override
    protected void initView() {


//        if (!flag) {
//            List<SquareItem> itemList = new ArrayList<>();
//
//            for (int i = 0; i <= 9; i++) {
//                SquareItem item = new SquareItem();
//                item.setTitle("东秦老黄历出问题了");
//                item.setPicture("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4113065710,2255729322&fm=26&gp=0.jpg");
//                itemList.add(item);
//            }
//
//            ToastUtil.showToast("出问题了，出问题了，出问题了");
//
//
//            SquareAdapter adapter = new SquareAdapter(itemList, this, R.layout.item_square);
//            adapter.setOnItemViewClickListener(this,1);
//            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//            /*GridLayoutManager mGridlayoutManager = new GridLayoutManager(this,3);*/
//            mRecommendRecyclerView.setAdapter(adapter);
//            mRecommendRecyclerView.setLayoutManager(layoutManager);
//            mRecommendRecyclerView.setNestedScrollingEnabled(false);
//        }

            recommendAdapter.setOnItemViewClickListener(this,1);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRecommendRecyclerView.setLayoutManager(layoutManager);
            mRecommendRecyclerView.setAdapter(recommendAdapter);
            mRecommendRecyclerView.setNestedScrollingEnabled(false);



//            allAdapter.setOnItemViewClickListener(new SquareAdapter.OnItemViewClickListener() {
//                @Override
//                public void OnClick(int position, int type) {
//
//                }
//            },2);

        allAdapter.setOnItemViewClickListener(this,2);

        GridLayoutManager mGridlayoutManager = new GridLayoutManager(this, 3);
        mSquareRecyclerView.setLayoutManager(mGridlayoutManager);
        mSquareRecyclerView.setAdapter(allAdapter);
        mSquareRecyclerView.setNestedScrollingEnabled(false);


        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initValue() {



        recommendAdapter = new SquareAdapter(mRecommendList,this,R.layout.item_square);
        mRecommendRecyclerView = (RecyclerView) findViewById(R.id.square_recycler_recommend);

        allAdapter = new SquareAdapter(mNormalList, this, R.layout.item_square);
        mSquareRecyclerView = (RecyclerView) findViewById(R.id.square_recycler_square);



        android.support.v4.widget.NestedScrollView square_NetedScrollView = (android.support.v4.widget.NestedScrollView) findViewById(R.id.square_neted);
        square_NetedScrollView.setOnScrollChangeListener(new android.support.v4.widget.NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(android.support.v4.widget.NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    if (!flag2) {
                        mPresenter.getNormal(page++);
                    }
                }
            }
        });


        imageBack = (ImageView) findViewById(R.id.square_back_arrow);


    }

    @Override
    protected void loadata() {

        mPresenter.getRecommend();

        mPresenter.getNormal(page++);

    }

    @Override
    protected ISquareContract.Presenter getPresenter() {
        return new SquarePresenter();
    }

    @Override
    public void onRecommendSucceed(List<SquareItem> list) {



        recommendAdapter.addItems(list);
        flag = true;

//        ToastUtil.showToast("I am going to die");
//        Log.d("SquareActivity", "here");
//        RecyclerView mRecommendRecyclerView = (RecyclerView) findViewById(R.id.square_recycler_recommend);
//       SquareAdapter adapter = new SquareAdapter(list, this, R.layout.item_square);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRecommendRecyclerView.setAdapter(adapter);
//        mRecommendRecyclerView.setLayoutManager(layoutManager);
//        mRecommendRecyclerView.setNestedScrollingEnabled(false);



    }

    @Override
    public void onNormalSucceed(List<SquareItem> list) {

        allAdapter.addItems(list);

    }

    @Override
    public void onRecommendFailed() {


    }

    @Override
    public void onNormalFailed() {

    }

    @Override
    public void getLastPage() {
        ToastUtil.showToast("已经是最后一页了");

        flag2 = true;
    }

    @Override
    public void OnClick(int position,int type) {

        switch (type){
            case 1:ToastUtil.showToast("死鬼，才来看我");
                   Intent intent = new Intent(SquareActivity.this, DetailActivity.class);
                   intent.putExtra("calendarId",recommendAdapter.getItem(position).getId());
                   startActivity(intent);
                    break;
            case 2: Intent intent2 = new Intent(SquareActivity.this, DetailActivity.class);
                   intent2.putExtra("calendarId",allAdapter.getItem(position).getId());
                   startActivity(intent2);
                   break;

        }




    }
}
