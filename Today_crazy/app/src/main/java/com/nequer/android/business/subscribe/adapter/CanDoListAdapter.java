package com.nequer.android.business.subscribe.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.nequer.android.base.adapter.BaseRecyclerViewAdapter;
import com.nequer.android.base.adapter.BaseViewHolder;
import com.nequer.android.business.account.model.UserInfo;
import com.nequer.android.business.subscribe.contract.SubscribeContract;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.neuqer.android.R;

import java.util.List;

public class CanDoListAdapter extends BaseRecyclerViewAdapter<CalendarModel.GoodBean> {


    private Boolean isGood;


    public CanDoListAdapter(List<CalendarModel.GoodBean> goodBeans, Context context, int itemLayoutId, Boolean isGood) {
        super(goodBeans, context, itemLayoutId);
        this.isGood = isGood;

    }

    @Override
    protected void bindView(BaseViewHolder viewHolder, CalendarModel.GoodBean item) {
        final int position = viewHolder.getViewHolderPosition();

        viewHolder.setText(R.id.item_calendar_can_do, item.getTitle())
                .setText(R.id.item_calendar_can_do_detail,item.getDescription());
        ImageView imageView = (ImageView)viewHolder.getItemView().findViewById(R.id.item_image_flag);
        if(isGood){
            imageView.setBackgroundColor(mContext.getResources().getColor(R.color.green));
        }else{
            imageView.setBackgroundColor(mContext.getResources().getColor(R.color.red));
        }


    }
}
