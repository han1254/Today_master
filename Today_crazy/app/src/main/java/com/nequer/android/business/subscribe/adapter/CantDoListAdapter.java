package com.nequer.android.business.subscribe.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.nequer.android.base.adapter.BaseRecyclerViewAdapter;
import com.nequer.android.base.adapter.BaseViewHolder;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.neuqer.android.R;

import java.util.List;

public class CantDoListAdapter extends BaseRecyclerViewAdapter<CalendarModel.BadBean> {
    public CantDoListAdapter(List<CalendarModel.BadBean> badBeanList, Context context, int itemLayoutId) {
        super(badBeanList, context, itemLayoutId);

    }

    @Override
    protected void bindView(BaseViewHolder viewHolder, CalendarModel.BadBean item) {
        viewHolder.setText(R.id.item_calendar_can_do,item.getTitle())
                .setText(R.id.item_calendar_can_do_detail,item.getDescription());
        ImageView imageView = (ImageView)viewHolder.getItemView().findViewById(R.id.item_image_flag);
        imageView.setBackgroundColor(mContext.getResources().getColor(R.color.red));
    }
}
