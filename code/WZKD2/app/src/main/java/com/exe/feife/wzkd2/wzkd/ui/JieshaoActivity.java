package com.exe.feife.wzkd2.wzkd.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Html.TagHandler;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.exe.feife.wzkd2.wzkd.R;
import com.exe.feife.wzkd2.wzkd.data.WZKDAPP;
import org.xml.sax.XMLReader;

public class JieshaoActivity extends Activity
        implements GestureDetector.OnGestureListener
{
    private GestureDetector gestureDetector;
    Html.ImageGetter imageGetter = new Html.ImageGetter()
    {
        @Override
        public Drawable getDrawable(String source) {
            int id = Integer.parseInt(source);
            Drawable drawable = context.getResources().getDrawable(id);
            drawable.setBounds(0, 0,screenwidth/5, screenheight/5);
            return drawable;
        }
    };
    private Resources res;
    int screenheight;
    int screenwidth;
    private TypedArray tupian;
    private ViewFlipper viewFlipper;
    private String weizhiname;
    private String[] zhinan;
    private TextView zhinanTextView;
    private Context context;

    private void init()
    {
        int currentBitmp=0;
        context=JieshaoActivity.this;
        this.weizhiname = "活动中心";
        this.res = getResources();
        this.tupian = this.res.obtainTypedArray(((Integer)WZKDAPP.name_tupian.get(this.weizhiname)).intValue());
        this.zhinan = this.res.getStringArray(((Integer)WZKDAPP.name_zhinan.get(this.weizhiname)).intValue());
        this.viewFlipper = ((ViewFlipper)findViewById(R.id.vf_jieshao));
        this.zhinanTextView = ((TextView)findViewById(R.id.zhinanneirong));
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
        for (int i = 0; i < this.zhinan.length; i++)
        {
            this.zhinanTextView.append("\n" + this.zhinan[i] + "\n");
            //从这里可以看出，每个图片有一个自己的handler，所以只要为handler绑定图片的id，就会在点击的时候获取到图片的id
            this.zhinanTextView.append(Html.fromHtml("<img src='"+R.mipmap.neijing+"'/>", this.imageGetter, new MTagHandler(this,R.mipmap.neijing)));
        }
        this.zhinanTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_jieshao);
        WZKDAPP.initJieshaoMap();
        init();
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


    public class MTagHandler implements TagHandler {
        private int sIndex = 0;
        private int eIndex = 0;
        private final Context mContext;
        private final int bitmapid;

        public MTagHandler(Context context,int bitmapId) {
            mContext = context;
            this.bitmapid=bitmapId;
        }

        public void handleTag(boolean opening, String tag, Editable output,
                              XMLReader xmlReader) {
            Log.d("标签",tag);
            if (tag.toLowerCase().equals("img")) {
                if (opening) {
                    sIndex = output.length();
                } else {
                    eIndex = output.length();
                    output.setSpan(new MSpan(), sIndex, eIndex,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    Log.d("内容",output.toString());
                }
            }
        }

        private class MSpan extends ClickableSpan implements OnClickListener {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, bitmapid+"", Toast.LENGTH_SHORT).show();
            }
        }
    }
}