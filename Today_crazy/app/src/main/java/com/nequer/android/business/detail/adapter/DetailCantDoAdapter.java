package com.nequer.android.business.detail.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.nequer.android.base.adapter.BaseRecyclerViewAdapter;
import com.nequer.android.base.adapter.BaseViewHolder;
import com.nequer.android.business.detail.mvp.model.DetailModel;
import com.neuqer.android.R;

import java.util.List;

public class DetailCantDoAdapter extends BaseRecyclerViewAdapter<DetailModel.PreviewBean.BadBean> {
    public DetailCantDoAdapter(List<DetailModel.PreviewBean.BadBean> badBeans, Context context, int itemLayoutId) {
        super(badBeans, context, itemLayoutId);
    }

    @Override
    protected void bindView(BaseViewHolder viewHolder, DetailModel.PreviewBean.BadBean item) {
        viewHolder.setText(R.id.item_calendar_can_do,item.getTitle())
                .setText(R.id.item_calendar_can_do_detail,item.getDescription());
        ImageView img = (ImageView)viewHolder.getItemView().findViewById(R.id.item_image_flag);
        img.setBackgroundColor(mContext.getResources().getColor(R.color.red));
    }
}
