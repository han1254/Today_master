package com.nequer.android.business.manage.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.nequer.android.base.adapter.BaseRecyclerViewAdapter;
import com.nequer.android.base.adapter.BaseViewHolder;
import com.nequer.android.business.manage.mvp.model.MyCreateModel;
import com.neuqer.android.R;

import java.util.List;

import butterknife.BindView;

public class MyCreateAdapter extends BaseRecyclerViewAdapter<MyCreateModel>{


    private int type;

    public MyCreateAdapter(List<MyCreateModel> list, Context context, int itemLayoutId) {
        super(list, context, itemLayoutId);
    }

    private onItemClickListener mOnItemClickListener;
    private onViewControlClickListener mOnViewContralClickListener;
    private onDeleClickListener mOnDleClickListener;

    @Override
    protected void bindView(BaseViewHolder viewHolder, MyCreateModel item) {
        final  int position = viewHolder.getViewHolderPosition();
        viewHolder.setImgUrl(R.id.item_mycreate_imag,item.getPicture())
                .setText(R.id.item_mycreate_txt_calendar_title,item.getTitle())
               .setText(R.id.item_mycreate_txt_subscribe_number,String.valueOf(item.getSubscribed()));

        LinearLayout mLinearEdit = (LinearLayout)viewHolder.getItemView().findViewById(R.id.item_mycreate_linear_edit);
        LinearLayout mLinearDele = (LinearLayout)viewHolder.getItemView().findViewById(R.id.item_mycreate_linear_delet);

        viewHolder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.OnClick(position,item.getId());
            }
        });

        mLinearEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnViewContralClickListener.OnViewClick(position,type,item.getId());
            }
        });


        mLinearDele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDleClickListener.OnDeleClick(position,type,item.getId());
            }
        });
    }

    public interface onItemClickListener{
        void OnClick(int position,int id);
    }
    public interface onViewControlClickListener{
        void OnViewClick(int position,int type,int id);
    }

    public interface onDeleClickListener{
        void OnDeleClick(int postion, int type,int id);
    }
    public void setOnItemClickListener(onItemClickListener listener){
        mOnItemClickListener = listener;
    }

    public void setmOnViewContralClickListener(onViewControlClickListener listener,int type){
        mOnViewContralClickListener = listener;
        this.type = type;
    }

    public void setmOnDleClickListener(onDeleClickListener listener, int type){
        mOnDleClickListener = listener;
        this.type = type;
    }
}
