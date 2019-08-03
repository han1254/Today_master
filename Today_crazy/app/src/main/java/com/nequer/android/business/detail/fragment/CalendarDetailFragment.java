package com.nequer.android.business.detail.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nequer.android.base.fragment.BaseFragment;
import com.nequer.android.business.detail.adapter.DetailCanDoAdapter;
import com.nequer.android.business.detail.adapter.DetailCantDoAdapter;
import com.nequer.android.business.detail.adapter.DetailRecommendAdapter;
import com.nequer.android.business.detail.mvp.model.DetailModel;
import com.nequer.android.business.subscribe.adapter.CanDoListAdapter;
import com.nequer.android.business.subscribe.adapter.CantDoListAdapter;
import com.nequer.android.business.subscribe.adapter.RecommendListAdapter;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.neuqer.android.R;

import java.util.List;

/**
 */
public class CalendarDetailFragment extends BaseFragment {

    private RecyclerView mGoodRecyclerView;
    private RecyclerView mBadRecyclerView;
    private RecyclerView mRecommendRecyclerView;
    private DetailModel detailModel;

    private DetailCanDoAdapter mCanDoAdapter;
    private DetailCantDoAdapter mCantDoAdapter;
    private DetailRecommendAdapter mRecommendAdapter;
    private RecyclerView.LayoutManager layoutManager;

   public static CalendarDetailFragment getInstance(DetailModel model){
       Bundle bundle = new Bundle();
       bundle.putSerializable("calendarDetail",model);
       CalendarDetailFragment fragment = new CalendarDetailFragment();
       fragment.setArguments(bundle);
       return fragment;
   }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_calendar_detail;
    }

    @Override
    protected void initVariable() {



        Bundle bundle = new Bundle();
        bundle = getArguments();
        assert bundle != null;
        detailModel = (DetailModel)bundle.getSerializable("calendarDetail");


        assert detailModel != null;
        mCanDoAdapter = new DetailCanDoAdapter(detailModel.getPreview().getGood(),this.getContext(),R.layout.item_can_do);
        mCantDoAdapter = new DetailCantDoAdapter(detailModel.getPreview().getBad(),this.getContext(),R.layout.item_can_do);
        mRecommendAdapter = new DetailRecommendAdapter(detailModel.getPreview().getRecommend(),this.getActivity(),R.layout.item_can_do);



        assert getFragmentView() != null;
        mGoodRecyclerView = (RecyclerView)getFragmentView().findViewById(R.id.frg_detail_good);
        mBadRecyclerView = (RecyclerView)getFragmentView().findViewById(R.id.frg_detail_bad);
        mRecommendRecyclerView = (RecyclerView)getFragmentView().findViewById(R.id.frg_detail_recommend);


    }

    @Override
    protected void initView() {

       mGoodRecyclerView.setAdapter(mCanDoAdapter);
       mGoodRecyclerView.setNestedScrollingEnabled(false);
       mGoodRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

       mBadRecyclerView.setAdapter(mCantDoAdapter);
       mBadRecyclerView.setNestedScrollingEnabled(false);
       mBadRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

       mRecommendRecyclerView.setAdapter(mRecommendAdapter);
       mRecommendRecyclerView.setNestedScrollingEnabled(false);
       mRecommendRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
