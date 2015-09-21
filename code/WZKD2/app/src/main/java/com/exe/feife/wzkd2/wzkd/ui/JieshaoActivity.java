package com.exe.feife.wzkd2.wzkd.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.View.OnClickListener;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Html;
import android.text.Html.TagHandler;

import com.exe.feife.wzkd2.wzkd.R;
import com.exe.feife.wzkd2.wzkd.data.Values;
import com.exe.feife.wzkd2.wzkd.data.WZKDAPP;
import com.exe.feife.wzkd2.wzkd.ui.view.SlideView;

import org.xml.sax.XMLReader;

import java.util.ArrayList;

import static android.content.SharedPreferences.*;

public class JieshaoActivity extends Activity
{
    private GestureDetector gestureDetector;
    private Resources res;
    private Context context;
    private TypedArray tupian;
    private TypedArray zhinantupian;
    private String weizhiname;
    private String[] zhinan;
    private int[] zhinantupianIds;
    private ArrayList<Integer> jieshaotupianIds;

    private SlideView slideView;
    private TextView zhinanlist;
    private ScrollView scrollView;
    private TextView didianName;
    private TextView jianjieneirong;
    private ImageButton collect;

    //检测是否被收藏的sharedpreferences
    private SharedPreferences sp;
    private int collectedFlag;

    int screenheight;
    int screenwidth;


    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_jieshao);
        WZKDAPP.initJieshaoMap();
        init();
    }

    //初始化一些控件和对象
    private void init()
    {
        context=this;
        this.res = getResources();
        sp=getSharedPreferences("collect",MODE_PRIVATE);
        this.scrollView=(ScrollView)findViewById(R.id.scrollView);
        Intent intent=getIntent();
        if (intent!=null)
        {
            this.weizhiname=intent.getStringExtra(Values.WEIZHINAME);
        }
        if (weizhiname==null)
        {
            this.weizhiname = "活动中心";
        }
        collectedFlag=sp.getInt(weizhiname,0);
        collect= (ImageButton) findViewById(R.id.bt_jieshao_collect);
        if (collectedFlag==0)
        {
            collect.setBackground(res.getDrawable(android.R.drawable.star_big_off));
        }
        this.jianjieneirong=(TextView)findViewById(R.id.jianjieneirong);
        this.zhinantupian=this.res.obtainTypedArray(((Integer) WZKDAPP.name_tips.get(this.weizhiname)).intValue());
        this.tupian = this.res.obtainTypedArray(((Integer) WZKDAPP.name_tupian.get(this.weizhiname)).intValue());
        this.zhinan = this.res.getStringArray(((Integer) WZKDAPP.name_zhinan.get(this.weizhiname)).intValue());
        this.slideView = (SlideView) findViewById(R.id.vf_jieshao);
        this.zhinanlist = ((TextView)findViewById(R.id.lv_zhinanneirong));
        this.didianName= (TextView) findViewById(R.id.tv_jieshao_didianname);
        zhinantupianIds=new int[zhinantupian.length()];
        //将指南图片的id放到数组里面
        for (int i=0;i<zhinantupian.length();i++)
        {
            zhinantupianIds[i]=zhinantupian.getResourceId(i,0);
        }
        zhinantupian.recycle();
        //将介绍图片的id放到数组里面
        jieshaotupianIds=new ArrayList<Integer>();
        for(int i=0;i<tupian.length();i++)
        {
            jieshaotupianIds.add(tupian.getResourceId(i,0));
        }
        tupian.recycle();
        didianName.setText(weizhiname);
        jianjieneirong.setText(context.getString((Integer) WZKDAPP.name_jianjie.get(this.weizhiname)));
        slideView.addPictureIds(jieshaotupianIds,R.mipmap.icon_viewpager_dot_normal,R.mipmap.icon_viewpager_dot_focus);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        this.screenheight = localDisplayMetrics.heightPixels;
        this.screenwidth = localDisplayMetrics.widthPixels;
        xiezhinan();
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
    }

    //解决滑动冲突问题
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        slideView.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    //填充下面的指南内容和图片
    private void xiezhinan()
    {
        for (int i=0;i<zhinan.length;i++)
        {
            zhinanlist.append("Tip"+(i+1)+":\n\t\t"+zhinan[i]+"\n\n");
            Log.d("xxxx", zhinantupianIds[i] + "");
            if (zhinantupianIds[i]!=0)
            {
                Log.d("....",zhinantupianIds[i]+"");
                zhinanlist.append(Html.fromHtml("<img src='" + zhinantupianIds[i] + "' />", this.imageGetter, new MTagHandler(context, zhinantupianIds[i])));
            }
            zhinanlist.setMovementMethod(LinkMovementMethod.getInstance());
        }
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
                }
            }
        }

        //图片点击事件处理
        private class MSpan extends ClickableSpan implements OnClickListener {
            @Override
            public void onClick(View view) {
                //请在这里设置点击跳转的Intent，
                /*
                *
                Intent i=new Intent(context,ActivityBroswePic.class);
                i.putExtra("picture", bitmapid);
                startActivity(i);
                */
            }
        }
    }
    //定义imagegetter来获取从xml传过来的图片
    Html.ImageGetter imageGetter = new Html.ImageGetter()
    {
        @Override
        public Drawable getDrawable(String source) {

            int id = Integer.parseInt(source);
            Drawable drawable = context.getResources().getDrawable(id);
            int picWidth=screenwidth-70;
            if (id!=R.mipmap.ic_launcher)
            {
                drawable.setBounds(0, 0, picWidth, drawable.getIntrinsicHeight() * (picWidth) / drawable.getIntrinsicWidth());
            }
            else
            {
                drawable.setBounds(0,0,0,0);
            }
            return drawable;
        }
    };



    @Override
    public void onResume()
    {
        super.onResume();
        collectedFlag=sp.getInt(weizhiname,0);
        if (collectedFlag==0)
        {
            collect.setBackground(res.getDrawable(R.mipmap.icon_detail_favorite));
        }
        else
        {
            collect.setBackground(res.getDrawable(R.mipmap.icon_detail_favorite_selected));
        }
    }

    //设置收藏地点
    public void collect(View v)
    {
        Toast.makeText(this,"",Toast.LENGTH_SHORT);
        Editor editor=sp.edit();
        if (collectedFlag==0)
        {
            //添加收藏
            editor.putInt(weizhiname,1);
            collect.setBackground(res.getDrawable(R.mipmap.icon_detail_favorite_selected));
            collectedFlag=1;
        }
        else
        {
            //移除收藏
            editor.putInt(weizhiname,0);
            collect.setBackground(res.getDrawable(R.mipmap.icon_detail_favorite));
            collectedFlag=0;
        }
        editor.commit();
    }


    public void zhinan(View v)
    {
        finish();
    }
}