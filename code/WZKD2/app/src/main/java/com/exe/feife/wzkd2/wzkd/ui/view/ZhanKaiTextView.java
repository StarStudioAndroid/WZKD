package com.exe.feife.wzkd2.wzkd.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.exe.feife.wzkd2.wzkd.R;

public class ZhanKaiTextView extends TextView
{
  private static int MAX_LINE_NUM;
  private static int MIN_LINE_NUM = 1;
  float PostitonX;
  float PostitonY;
  Bitmap bitmapDown;
  Bitmap bitmapUp;
  int h;
  int he;
  private int lineNum = MIN_LINE_NUM;
  private boolean mIsExpanded = false;
  private String title;
  int w;
  int we;

  static
  {
    MAX_LINE_NUM = 20;
  }

  public ZhanKaiTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }

  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    setMaxLines(this.lineNum);
    this.bitmapDown = BitmapFactory.decodeResource(getResources(), R.mipmap.update_detail_down);
    this.bitmapUp = BitmapFactory.decodeResource(getResources(), R.mipmap.update_detail_up);
    this.we = (int)paramContext.getResources().getDimension(R.dimen.expand_textview_right);
    this.he = (int)paramContext.getResources().getDimension(R.dimen.expand_textview_bottom);
    this.w = (this.bitmapDown.getWidth() + (int)paramContext.getResources().getDimension(R.dimen.expand_textview_right));
    this.h = (this.bitmapDown.getHeight() + (int)paramContext.getResources().getDimension(R.dimen.expand_textview_bottom));
    this.title = "标题";
  }

  public boolean isExpanded()
  {
    return this.mIsExpanded;
  }

  protected void onDraw(Canvas canvas)
  {
    //画出标题
    Paint localPaint = new Paint();
    localPaint.setColor(getResources().getColor(android.R.color.black));
    localPaint.setTextSize(60);
    localPaint.setUnderlineText(true);
    localPaint.setStrokeWidth(10.0F);
    canvas.drawText(this.title, this.we, 55 + this.he, localPaint);
    //画出图标
    this.PostitonX = (getWidth() - this.w);
    this.PostitonY = (getHeight() - this.h);
    if (getLineCount() <= MIN_LINE_NUM) {
      super.onDraw(canvas);
      return;
    }
    if (lineNum == MIN_LINE_NUM) {
      canvas.drawBitmap(bitmapDown, getWidth() - w, getHeight() - h, null);
    } else {
      canvas.drawBitmap(bitmapUp, getWidth() - w, getHeight() - h, null);
    }
    super.onDraw(canvas);
  }

  public boolean onTouchEvent(MotionEvent event)
  {
    if ((Math.abs(event.getX() - this.PostitonX - this.w / 2) < 50.0F) && (Math.abs(event.getY() - this.PostitonY - this.h / 2) < 50.0F))
    {
      if (lineNum == MIN_LINE_NUM) {
        lineNum = MAX_LINE_NUM;
        setMaxLines(lineNum);
      } else {
        lineNum = MIN_LINE_NUM;
        setMaxLines(lineNum);
      }
    }
    return super.onTouchEvent(event);
  }

  //设置行数
  public void setMaxLine(int paramInt)
  {
    this.lineNum = paramInt;
    setMaxLines(paramInt);
  }

  //设置展开
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    //标记当前状态为展开状态
    if (this.lineNum == MAX_LINE_NUM)
    {
      this.mIsExpanded = true;
      return;
    }
    this.mIsExpanded = false;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}
