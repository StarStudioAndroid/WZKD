package com.exe.feife.wzkd2.wzkd.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.exe.feife.wzkd2.wzkd.R;

/**
 * Created by feifei on 15-8-30.
 */
public class MyImageFlipper extends ViewFlipper implements GestureDetector.OnGestureListener {
    private Context mContext;
    public GestureDetector gestureDetector;

    public MyImageFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        this.gestureDetector=new GestureDetector(mContext,this);
    }


    public void addImages(TypedArray tupian)
    {
        for (int i = 0; i < tupian.length(); i++)
        {
            ImageView localImageView = new ImageView(mContext);
            localImageView.setImageDrawable(tupian.getDrawable(i));
            this.addView(localImageView, new ViewGroup.LayoutParams(-1, -1));
        }
        tupian.recycle();
    }


    //绘制小圆点
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 10, paint);
        Log.d("ondraw","ondraw");
    }

    public boolean onDown(MotionEvent paramMotionEvent) {return false;}

    //监听侧滑事件
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
        if (paramMotionEvent1.getX() - paramMotionEvent2.getX() > 120.0F)
        {
            this.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.push_left_in));
            this.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.push_left_out));
            this.showNext();
        }
        else if (paramMotionEvent1.getX() - paramMotionEvent2.getX() <= -120.0F) {
            this.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.push_right_in));
            this.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.push_right_out));
            this.showPrevious();
        }
        return true;
    }

    public void onLongPress(MotionEvent paramMotionEvent) {}

    public boolean onScroll(MotionEvent event1, MotionEvent event2, float x, float y) {return false;}

    public void onShowPress(MotionEvent paramMotionEvent) {}

    public boolean onSingleTapUp(MotionEvent paramMotionEvent) {return false;}

    public boolean onTouchEvent(MotionEvent event) {return this.gestureDetector.onTouchEvent(event);}
}
