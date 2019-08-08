package com.nequer.android.utils;


import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lwkandroid.imagepicker.utils.IImagePickerDisplayer;
import com.neuqer.android.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

public class ImagePickerUtil implements IImagePickerDisplayer {
    @Override
    public void display(Context context, String url, ImageView imageView, int maxWidth, int maxHeight) {
        Picasso.with(context)//
                .load(url)//
                .placeholder(R.drawable.ic_launcher_background)//
                .error(R.drawable.ic_launcher_background)//
                .resize(maxWidth, maxHeight)//
                .centerInside()//
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)//
                .into(imageView);
    }

    @Override
    public void display(Context context, String url, ImageView imageView, int placeHolder, int errorHolder, int maxWidth, int maxHeight) {

//        Picasso.with(context)
//                .load(url)
//                .placeholder(placeHolder)
//                .error(errorHolder)
//                .resize(maxWidth, maxHeight)
//                .into(imageView);
        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}
