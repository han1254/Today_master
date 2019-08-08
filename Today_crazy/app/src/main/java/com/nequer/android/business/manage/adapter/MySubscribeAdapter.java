package com.nequer.android.business.manage.adapter;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nequer.android.base.adapter.BaseRecyclerViewAdapter;
import com.nequer.android.base.adapter.BaseViewHolder;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.neuqer.android.R;

import java.util.List;

public class MySubscribeAdapter extends BaseRecyclerViewAdapter<CalendarModel> {

    private onItemClickListener mOnItemClicklistener;
    private onCancelListener mOnCancelClickListener;

    @Override
    public int getItemCount() {
        return 10;
    }

    public MySubscribeAdapter(List<CalendarModel> calendarModelList, Context context, int itemLayoutId) {
        super(calendarModelList, context, itemLayoutId);
    }

    @Override
    protected void bindView(BaseViewHolder viewHolder, CalendarModel item) {

        viewHolder.setImgUrl(R.id.item_mysubscribe_imag,item.getCalendarPicture())
                .setText(R.id.item_mysubscribe_txt_calendar_title,item.getCalendarName());
        viewHolder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClicklistener.onClickItem(item.getCalendarId());
            }
        });

        LinearLayout linearCancel = viewHolder.itemView.findViewById(R.id.item_mysubscribe_linear_cancel);
        linearCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnCancelClickListener.onCancelClickItem(item.getCalendarId(),viewHolder.getViewHolderPosition());
            }
        });


    }

    public interface onItemClickListener{
        void onClickItem(int id);
    }

    public interface onCancelListener{
        void onCancelClickItem(int id,int position);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        mOnItemClicklistener = listener;
    }

    public void setmOnCancelClickListener(onCancelListener listener){
        mOnCancelClickListener = listener;
    }
}
