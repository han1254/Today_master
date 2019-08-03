package com.nequer.android.business.detail.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.nequer.android.base.adapter.BaseRecyclerViewAdapter;
import com.nequer.android.base.adapter.BaseViewHolder;
import com.nequer.android.business.detail.mvp.model.DetailModel;
import com.neuqer.android.R;

import java.util.List;

public class DetailRecommendAdapter extends BaseRecyclerViewAdapter<DetailModel.PreviewBean.RecommendBean> {
    public DetailRecommendAdapter(List<DetailModel.PreviewBean.RecommendBean> recommendBeans, Context context, int itemLayoutId) {
        super(recommendBeans, context, itemLayoutId);
    }

    @Override
    protected void bindView(BaseViewHolder viewHolder, DetailModel.PreviewBean.RecommendBean item) {
        StringBuilder recommond = new StringBuilder();
        for(String i:item.getItems()){
            recommond.append(i);
        }
        viewHolder.setText(R.id.item_calendar_can_do,item.getName())
                .setText(R.id.item_calendar_can_do_detail,recommond.toString());
        ImageView imageView = (ImageView)viewHolder.getItemView().findViewById(R.id.item_image_flag);
        imageView.setBackgroundColor(mContext.getResources().getColor(R.color.orange));
    }
}
