package com.nequer.android.business.subscribe.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.nequer.android.base.adapter.BaseRecyclerViewAdapter;
import com.nequer.android.base.adapter.BaseViewHolder;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.neuqer.android.R;

import java.util.List;

public class RecommendListAdapter extends BaseRecyclerViewAdapter<CalendarModel.RecommendBean> {
    public RecommendListAdapter(List<CalendarModel.RecommendBean> recommendBeans, Context context, int itemLayoutId) {
        super(recommendBeans, context, itemLayoutId);
    }

    @Override
    protected void bindView(BaseViewHolder viewHolder, CalendarModel.RecommendBean item) {


        StringBuilder recommend = new StringBuilder();
        for(String t: item.getItems()){
            recommend.append(t);
        }

        Log.d("lookkkkk",recommend.toString());
        viewHolder.setText(R.id.item_calendar_recommend,item.getName())
                .setText(R.id.txt_calendar_recommend_description, recommend.toString());
        ImageView imageView = (ImageView)viewHolder.getItemView().findViewById(R.id.item_image_flag_recommend);
        imageView.setBackgroundColor(mContext.getResources().getColor(R.color.orange));
    }
}
