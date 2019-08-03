package com.nequer.android.business.square.adapter;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import com.nequer.android.base.adapter.BaseRecyclerViewAdapter;
import com.nequer.android.base.adapter.BaseViewHolder;
import com.nequer.android.business.square.mvp.model.SquareItem;
import com.neuqer.android.R;

import java.util.List;

public class SquareAdapter extends BaseRecyclerViewAdapter<SquareItem> {

    private OnItemViewClickListener mOnItemViewClickListener;
    private int type = 1;

    public SquareAdapter(List<SquareItem> list, Context context, int layoutId) {
        super(list, context, layoutId);
    }

    public SquareAdapter(Context context, int layoutId){
        super(null, context, layoutId);
    }



    @Override
    protected void bindView(BaseViewHolder viewHolder, SquareItem item) {

        final int position = viewHolder.getViewHolderPosition();

        viewHolder.setText(R.id.square_item_txt_calendar_name,item.getTitle())
                .setImgUrl(R.id.square_item_image,item.getPicture());

        viewHolder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemViewClickListener.OnClick(position,type);

            }
        });
    }

    public interface OnItemViewClickListener{
        void OnClick(int position,int type);
    }

    public void setOnItemViewClickListener(OnItemViewClickListener itemViewClickListener,int type){

        this.mOnItemViewClickListener = itemViewClickListener;
        this.type = type;
    }


}
