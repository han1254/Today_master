package com.nequer.android.business.manage.mvp.view.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.base.mvp.view.BasePresenterFragment;
import com.nequer.android.business.manage.adapter.MySubscribeAdapter;
import com.nequer.android.business.manage.iconract.IMySubscribeContract;
import com.nequer.android.business.manage.mvp.presenter.MySubscribePresenter;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.nequer.android.common.CacheKey;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MySubscribeFragment extends BasePresenterFragment<IMySubscribeContract.Presenter> implements IMySubscribeContract.View{

    private List<CalendarModel> calendarModelList = new ArrayList<>();
    private MySubscribeAdapter adapter;
    private RecyclerView recyclerView;

    public static MySubscribeFragment getInstance(List<CalendarModel> list){
        Bundle bundle = new Bundle();
        bundle.putSerializable(CacheKey.KEY_MYSUBSCRIBE_LIST, (Serializable) list);
        MySubscribeFragment fragment = new MySubscribeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_subscribe;
    }

    @Override
    protected void initData() {



    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getSubscribe();
    }

    @Override
    protected void initValuable() {

    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        calendarModelList = (List<CalendarModel>) bundle.getSerializable(CacheKey.KEY_MYSUBSCRIBE_LIST);

        adapter.addItems(calendarModelList);
        adapter = new MySubscribeAdapter(calendarModelList,getActivity(),R.layout.item_my_subscribe);
        recyclerView = getView().findViewById(R.id.fragment_mysubscribe_recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setOnItemClickListener(new MySubscribeAdapter.onItemClickListener() {
            @Override
            public void onClickItem(int id) {
                ToastUtil.showToast("该item的id："+String.valueOf(id));
            }
        });

        adapter.setmOnCancelClickListener(new MySubscribeAdapter.onCancelListener() {
            @Override
            public void onCancelClickItem(int id) {
                ToastUtil.showToast("该控件的id："+String.valueOf(id));
            }
        });

    }

    @Override
    protected IMySubscribeContract.Presenter getPresenter() {
        return new MySubscribePresenter();
    }

    @Override
    public void onGetSubscribeSucceed(List<CalendarModel> list) {
//        calendarModelList = list;
//        adapter.addItems(list);
//        adapter = new MySubscribeAdapter(calendarModelList,getActivity(),R.layout.item_my_subscribe);
//        recyclerView = getView().findViewById(R.id.fragment_mysubscribe_recycler);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        adapter.setOnItemClickListener(new MySubscribeAdapter.onItemClickListener() {
//            @Override
//            public void onClickItem(int id) {
//                ToastUtil.showToast("该item的id："+String.valueOf(id));
//            }
//        });
//
//        adapter.setmOnCancelClickListener(new MySubscribeAdapter.onCancelListener() {
//            @Override
//            public void onCancelClickItem(int id) {
//                ToastUtil.showToast("该控件的id："+String.valueOf(id));
//            }
//        });
    }

    @Override
    public void onGetSubscribeFailed() {

    }
}
