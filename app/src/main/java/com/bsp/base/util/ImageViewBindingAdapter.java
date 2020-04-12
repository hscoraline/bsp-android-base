package com.bsp.base.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageViewBindingAdapter {

    @BindingAdapter("android:imageUrl")
    public static <T> void setImage(ImageView view, T url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    @BindingAdapter("android:circleImageUrl")
    public static <T> void loadCircleImage(ImageView view, T url) {
        Glide.with(view.getContext()).load(url).apply(RequestOptions.circleCropTransform()).into(view);
    }
}
