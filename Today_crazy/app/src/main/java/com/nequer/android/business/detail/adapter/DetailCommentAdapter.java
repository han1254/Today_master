package com.nequer.android.business.detail.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.nequer.android.Application;
import com.nequer.android.base.adapter.BaseRecyclerViewAdapter;
import com.nequer.android.base.adapter.BaseViewHolder;
import com.nequer.android.business.detail.mvp.model.DetailCommentModel;
import com.nequer.android.utils.TimeUtil;
import com.neuqer.android.R;

import java.util.List;

public class DetailCommentAdapter extends BaseRecyclerViewAdapter<DetailCommentModel> {

    public DetailCommentAdapter(List<DetailCommentModel> detailCommentModels, Context context, int itemLayoutId) {
        super(detailCommentModels, context, itemLayoutId);
    }

    @Override
    protected void bindView(BaseViewHolder viewHolder, DetailCommentModel item) {
        viewHolder.setText(R.id.item_detail_comment_txt_name,item.getUserName())
                .setText(R.id.item_detail_comment_txt_time, TimeUtil.setStampToString(item.getCreatedAt(),TimeUtil.DATETIME_DEFAULT_FORMAT))
                .setText(R.id.item_comment_txt_info,item.getComment())
               .setCircleImgUrl(R.id.item_detail_comment_image_user_avatar,item.getUserAvator());
        ImageView userAvatar = viewHolder.getItemView().findViewById(R.id.item_detail_comment_image_user_avatar);
        if(item.getUserAvator() == null){
            Glide.with(mContext.getApplicationContext())
                    .load(R.drawable.ic_user)
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(userAvatar);
        }

       //userAvatar.setImageResource(R.drawable.ic_have_subscribed);
    }
}
