package com.exe.feife.wzkd2.wzkd.data;

import android.app.Application;

import com.exe.feife.wzkd2.wzkd.R;

import java.util.HashMap;
import java.util.Map;

public class WZKDAPP extends Application
{
  public static Map<String, Integer> name_tupian;
  public static Map<String, Integer> name_zhinan;

  public static void initJieshaoMap()
  {
    name_zhinan = new HashMap();
    name_tupian = new HashMap();
    name_zhinan.put("活动中心", Integer.valueOf(R.array.huodongzhongxinzhi));
    name_tupian.put("活动中心", Integer.valueOf(R.array.huodongzhongxintu));
  }
}
