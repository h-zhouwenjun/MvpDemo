package com.example.zwj.mvpdemo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * <b>创建时间</b> 17/6/8 <br>
 *
 * @author zhouwenjun
 */

public class ImageLoader {

    public static void load(Context context, String url, ImageView iv) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//让Glide既缓存全尺寸图片，下次在任何ImageView中加载图片的时候，全尺寸的图片将从缓存中取出，重新调整大小，然后缓存
                .crossFade()
                .into(iv);
    }

    public static void load(Context context, String url, ImageView iv, int placeholder) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//让Glide既缓存全尺寸图片，下次在任何ImageView中加载图片的时候，全尺寸的图片将从缓存中取出，重新调整大小，然后缓存
                .crossFade()
                .placeholder(placeholder)
                .into(iv);
    }

    public static void load(Context context, int resId, ImageView iv) {
        Glide.with(context)
                .load(resId)
                .crossFade()
                .into(iv);
    }

    /**
     * 需要在子线程执行
     *
     * @param context
     * @param url
     * @return
     */
    public static Bitmap load(Context context, String url) {
        try {
            return Glide.with(context)
                    .load(url)
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void loadCircle(Context context, int resId, ImageView iv) {
        CropCircleTransformation cropCircleTransformation = new CropCircleTransformation(context);
        Glide.with(context)
                .load(resId)
                .crossFade()
                .bitmapTransform(cropCircleTransformation)
                .into(iv);
    }
}
