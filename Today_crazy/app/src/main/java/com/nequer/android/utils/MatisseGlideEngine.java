package com.nequer.android.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.zhihu.matisse.engine.ImageEngine;

/**
 * 解决4.0以后使用Glide出现的NoSuchMethodError问题
 *
 * @author chengkun
 * @since 2018/12/30 20:26
 */
public class MatisseGlideEngine implements ImageEngine {
    @Override
    public void loadThumbnail(Context context, int resize, Drawable placeholder, ImageView imageView, Uri uri) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeholder)
                //.error(R.drawable.error)
                .override(resize, resize);
        Glide.with(context)
                .asBitmap()  // some .jpeg files are actually gif
                .load(uri)
                .apply(options)
                .into(imageView);
    }

    @Override
    public void loadGifThumbnail(Context context, int resize, Drawable placeholder, ImageView imageView,
                                 Uri uri) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeholder)
                //.error(R.drawable.error)
                .override(resize, resize);
        Glide.with(context)
                .asBitmap()
                .load(uri)
                .apply(options)
                .into(imageView);
    }

    @Override
    public void loadImage(Context context, int resizeX, int resizeY, ImageView imageView, Uri uri) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .override(resizeX, resizeY)
                .priority(Priority.HIGH);
        Glide.with(context)
                .load(uri)
                .apply(options)
                .into(imageView);
    }

    @Override
    public void loadGifImage(Context context, int resizeX, int resizeY, ImageView imageView, Uri uri) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .override(resizeX, resizeY)
                .priority(Priority.HIGH);
        Glide.with(context)
                .asGif()
                .load(uri)
                .apply(options)
                .into(imageView);

    }

    @Override
    public boolean supportAnimatedGif() {
        return true;
    }

}
