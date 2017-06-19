package com.example.zwj.mvpdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * <b>创建时间</b> 17/6/8 <br>
 *
 * @author zhouwenjun
 */

public class ScaleImgView extends ImageView{

    private int initWidth;
    private int initHeight;

    public ScaleImgView(Context context) {
        this(context, null);
    }

    public ScaleImgView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setInitSize(int initWidth, int initHeight) {
        this.initWidth = initWidth;
        this.initHeight = initHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (initWidth > 0 && initHeight > 0) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = MeasureSpec.getSize(heightMeasureSpec);

            float scale = (float) initHeight / (float) initWidth;
            if (width > 0){
                height = (int) ((float)width * scale);
            }
            setMeasuredDimension(width, height);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

}
