package com.exe.feife.wzkd2.wzkd.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.exe.feife.wzkd2.wzkd.R;
import com.exe.feife.wzkd2.wzkd.data.WZKDAPP;

public class JieshaoActivity extends Activity
        implements GestureDetector.OnGestureListener
{
    private GestureDetector gestureDetector;
    private Resources res;
    int screenheight;
    int screenwidth;
    private TypedArray tupian;
    private ViewFlipper viewFlipper;
    private TextView zhinanlist;
    private String weizhiname;
    private String[] zhinan;


    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_jieshao);
        WZKDAPP.initJieshaoMap();
        init();
    }

    //初始化一些控件
    private void init()
    {
        this.weizhiname = "活动中心";
        this.res = getResources();
        this.tupian = this.res.obtainTypedArray(((Integer) WZKDAPP.name_tupian.get(this.weizhiname)).intValue());
        this.zhinan = this.res.getStringArray(((Integer)WZKDAPP.name_zhinan.get(this.weizhiname)).intValue());
        this.viewFlipper = ((ViewFlipper)findViewById(R.id.vf_jieshao));
        this.zhinanlist = ((TextView)findViewById(R.id.lv_zhinanneirong));
        this.gestureDetector = new GestureDetector(this, this);
        for (int i = 0; i < this.tupian.length(); i++)
        {
            ImageView localImageView = new ImageView(this);
            localImageView.setImageDrawable(this.tupian.getDrawable(i));
            this.viewFlipper.addView(localImageView, new ViewGroup.LayoutParams(-1, -1));
        }
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        this.screenheight = localDisplayMetrics.heightPixels;
        this.screenwidth = localDisplayMetrics.widthPixels;
        xiezhinan();
    }

    private void xiezhinan()
    {
        for (int i=0;i<zhinan.length;i++)
        {
            zhinanlist.append("Tip"+(i+1)+":\n\t\t"+zhinan[i]+"\n\n");
        }
    }


    public boolean onDown(MotionEvent paramMotionEvent) {return false;}

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
        if (paramMotionEvent1.getX() - paramMotionEvent2.getX() > 120.0F)
        {
            this.viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
            this.viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
            this.viewFlipper.showNext();
        }
        else if (paramMotionEvent1.getX() - paramMotionEvent2.getX() <= -120.0F) {
            this.viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
            this.viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
            this.viewFlipper.showPrevious();
        }
        return true;
    }

    public void onLongPress(MotionEvent paramMotionEvent) {}

    public boolean onScroll(MotionEvent event1, MotionEvent event2, float x, float y) {return false;}

    public void onShowPress(MotionEvent paramMotionEvent) {}

    public boolean onSingleTapUp(MotionEvent paramMotionEvent) {return false;}

    public boolean onTouchEvent(MotionEvent event) {return this.gestureDetector.onTouchEvent(event);}

    public void zhinan(View paramView) {startActivity(new Intent(this, ZhinanActivity.class));}

    public void toRight(View view) {
        this.viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
        this.viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
        this.viewFlipper.showPrevious();
    }

    public void toLeft(View v)
    {
        this.viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
        this.viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
        this.viewFlipper.showNext();
    }
}