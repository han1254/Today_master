package com.nequer.android.business.subscribe.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nequer.android.base.fragment.BaseFragment;
import com.nequer.android.business.subscribe.adapter.CanDoListAdapter;
import com.nequer.android.business.subscribe.adapter.CantDoListAdapter;
import com.nequer.android.business.subscribe.adapter.RecommendListAdapter;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.nequer.android.common.Config;
import com.neuqer.android.R;

import java.util.ArrayList;
import java.util.List;


public class SubscribedFragment extends BaseFragment {

    private CanDoListAdapter canDoListAdapter;
    private CantDoListAdapter cantDoListAdapter;
    private RecommendListAdapter recommendListAdapter;
    private CalendarModel calendarModel;
    private ImageView imageView;

    RecyclerView mGoodRecyclerView;
    RecyclerView mBadRecylerView;
    RecyclerView mRecommendRecyclerView;

    LinearLayoutManager layoutManager;
    List <CalendarModel.GoodBean> list = new ArrayList<>();
    List <CalendarModel.BadBean> badBeanList = new ArrayList<>();
    List<CalendarModel.RecommendBean> recommendBeanList = new ArrayList<>();

    

    public static SubscribedFragment newInstance(CalendarModel calendarModel){
        Bundle bundle = new Bundle();
        bundle.putSerializable(Config.CALENDAR,calendarModel);
        SubscribedFragment subscribedFragment = new SubscribedFragment();
        subscribedFragment.setArguments(bundle);
        return subscribedFragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_subscribed;
    }

    @Override
    protected void initVariable() {

        Bundle bundle = getArguments();
        assert bundle != null;
        calendarModel = (CalendarModel) bundle.getSerializable(Config.CALENDAR);
        assert calendarModel != null;
        list = calendarModel.getGood();
        badBeanList = calendarModel.getBad();
        recommendBeanList = calendarModel.getRecommend();
        canDoListAdapter = new CanDoListAdapter(list, getContext(),R.layout.item_can_do,true);
        cantDoListAdapter = new CantDoListAdapter(badBeanList,getContext(),R.layout.item_can_do);
        recommendListAdapter = new RecommendListAdapter(recommendBeanList,getContext(),R.layout.item_recommend);
        layoutManager = new LinearLayoutManager(getActivity());

    }

    @Override
    protected void initView() {

        mGoodRecyclerView = (RecyclerView)getFragmentView().findViewById(R.id.recycler_can_do);
        mBadRecylerView = (RecyclerView)getFragmentView().findViewById(R.id.recycler_cant_do);
        mRecommendRecyclerView = (RecyclerView)getFragmentView().findViewById(R.id.recycler_recomend);
        imageView = (ImageView)getFragmentView().findViewById(R.id.qiuqiunile);

        mGoodRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mGoodRecyclerView.setAdapter(canDoListAdapter);
        mGoodRecyclerView.setNestedScrollingEnabled(false);

        mBadRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBadRecylerView.setAdapter(cantDoListAdapter);
        mBadRecylerView.setNestedScrollingEnabled(false);

        mRecommendRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecommendRecyclerView.setAdapter(recommendListAdapter);
        mRecommendRecyclerView.setNestedScrollingEnabled(false);

        Glide.with(this)
                .load(calendarModel.getCalendarPicture())
                .into(imageView);

    }
}
