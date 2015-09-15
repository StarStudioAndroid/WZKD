package com.exe.feife.wzkd2.wzkd.data;

import android.app.Application;
import android.content.Context;

import com.exe.feife.wzkd2.wzkd.R;

import java.util.HashMap;
import java.util.Map;

public class WZKDAPP extends Application
{
  public static Map<String, Integer> name_tupian;
  public static Map<String, Integer> name_zhinan;
  public static Map<String,Integer> name_tips;
  public static Map<String,Integer> name_jianjie;
  public Context context=this.getApplicationContext();

  public static void initJieshaoMap()
  {
    name_zhinan = new HashMap();
    name_tupian = new HashMap();
    name_jianjie=new HashMap<>();
    name_tips=new HashMap<>();
    name_zhinan.put(Values.HUODONGZHONGXIN, Integer.valueOf(R.array.huodongzhongxinzhi));
    name_tupian.put(Values.HUODONGZHONGXIN, Integer.valueOf(R.array.huodongzhongxintu));
    name_tips.put(Values.HUODONGZHONGXIN,Integer.valueOf(R.array.huodongzhongxint));
    name_jianjie.put(Values.HUODONGZHONGXIN,R.string.huodongzhongxin);
    name_zhinan.put(Values.YISHITANG,Integer.valueOf(R.array.yishitangzhi));
    name_tupian.put(Values.YISHITANG,Integer.valueOf(R.array.yishitangtu));
    name_tips.put(Values.YISHITANG,Integer.valueOf(R.array.yishitangt));
    name_jianjie.put(Values.YISHITANG,R.string.yishitang);
    name_zhinan.put(Values.CHENGDIANHUITANG,Integer.valueOf(R.array.chengdianhuitangzhi));
    name_tupian.put(Values.CHENGDIANHUITANG,Integer.valueOf(R.array.chengdianhuitangtu));
    name_tips.put(Values.CHENGDIANHUITANG,Integer.valueOf(R.array.chengdianhuitangt));
    name_jianjie.put(Values.CHENGDIANHUITANG,R.string.chengdianhuitang);
    name_zhinan.put(Values.TUSHUGUAN,Integer.valueOf(R.array.tushuguanzhi));
    name_tupian.put(Values.TUSHUGUAN,Integer.valueOf(R.array.tushuguantu));
    name_tips.put(Values.TUSHUGUAN,Integer.valueOf(R.array.tushuguant));
    name_jianjie.put(Values.TUSHUGUAN,R.string.tushuguan);
    name_zhinan.put(Values.XIAOYIYUAN,Integer.valueOf(R.array.xiaoyiyuanzhi));
    name_tupian.put(Values.XIAOYIYUAN,Integer.valueOf(R.array.xiaoyiyuantu));
    name_tips.put(Values.XIAOYIYUAN,Integer.valueOf(R.array.xiaoyiyuant));
    name_jianjie.put(Values.XIAOYIYUAN,R.string.xiaoyiyuan);
    name_zhinan.put(Values.YINGXINGDADAO,Integer.valueOf(R.array.yishitangzhi));
    name_tupian.put(Values.YINGXINGDADAO,Integer.valueOf(R.array.yingxindadaotu));
    name_tips.put(Values.YINGXINGDADAO,Integer.valueOf(R.array.yingxindadaot));
    name_jianjie.put(Values.YINGXINGDADAO,R.string.yingxindadao);
    name_zhinan.put(Values.ZHULOU,Integer.valueOf(R.array.zhulouzhi));
    name_tupian.put(Values.ZHULOU,Integer.valueOf(R.array.zhuloutu));
    name_tips.put(Values.ZHULOU,Integer.valueOf(R.array.zhulout));
    name_jianjie.put(Values.ZHULOU,R.string.zhulou);
    name_zhinan.put(Values.KEYANLOU,Integer.valueOf(R.array.keyanlouzhi));
    name_tupian.put(Values.KEYANLOU,Integer.valueOf(R.array.keyanloutu));
    name_tips.put(Values.KEYANLOU,Integer.valueOf(R.array.keyanlout));
    name_jianjie.put(Values.KEYANLOU,R.string.keyanlou);
    name_zhinan.put(Values.PINGXUELOU,Integer.valueOf(R.array.pingxuelouzhi));
    name_tupian.put(Values.PINGXUELOU,Integer.valueOf(R.array.pingxueloutu));
    name_tips.put(Values.PINGXUELOU,Integer.valueOf(R.array.pingxuelout));
    name_jianjie.put(Values.PINGXUELOU,R.string.pingxuelou);
    name_zhinan.put(Values.SHIYANLOU,Integer.valueOf(R.array.shiyanlouzhi));
    name_tupian.put(Values.SHIYANLOU,Integer.valueOf(R.array.shiyanloutu));
    name_tips.put(Values.SHIYANLOU,Integer.valueOf(R.array.shiyanlout));
    name_jianjie.put(Values.SHIYANLOU,R.string.shiyanlou);
    name_zhinan.put(Values.TIYUYUNDONGZHONGXIN,Integer.valueOf(R.array.tiyuyundongzhongxinzhi));
    name_tupian.put(Values.TIYUYUNDONGZHONGXIN,Integer.valueOf(R.array.tiyuyundongzhongxintu));
    name_tips.put(Values.TIYUYUNDONGZHONGXIN,Integer.valueOf(R.array.tiyuyundongzhongxint));
    name_jianjie.put(Values.TIYUYUNDONGZHONGXIN,R.string.tiyuyundongzhongxin);
    name_zhinan.put(Values.ZONGHEXUNLIANGUAN,Integer.valueOf(R.array.zonghexunlianguanzhi));
    name_tupian.put(Values.ZONGHEXUNLIANGUAN,Integer.valueOf(R.array.zhonghexunlianguantu));
    name_tips.put(Values.ZONGHEXUNLIANGUAN,Integer.valueOf(R.array.zonghexunlianguant));
    name_jianjie.put(Values.ZONGHEXUNLIANGUAN,R.string.zonghexunlianguan);
    name_zhinan.put(Values.ZONGHELOU,Integer.valueOf(R.array.zonghelouzhi));
    name_tupian.put(Values.ZONGHELOU,Integer.valueOf(R.array.zongheloutu));
    name_tips.put(Values.ZONGHELOU,Integer.valueOf(R.array.zhulout));
    name_jianjie.put(Values.ZONGHELOU,R.string.zonghelou);
    name_zhinan.put(Values.SHANGEYEJIE,Integer.valueOf(R.array.shangyejiezhi));
    name_tupian.put(Values.SHANGEYEJIE,Integer.valueOf(R.array.shangyejietu));
    name_tips.put(Values.SHANGEYEJIE,Integer.valueOf(R.array.shangyejiet));
    name_jianjie.put(Values.SHANGEYEJIE,R.string.shangyejie);
    name_zhinan.put(Values.ERSHITANG,Integer.valueOf(R.array.ershitangzhi));
    name_tupian.put(Values.ERSHITANG,Integer.valueOf(R.array.ershitangtu));
    name_tips.put(Values.ERSHITANG,Integer.valueOf(R.array.ershitangt));
    name_jianjie.put(Values.ERSHITANG,R.string.ershitang);
    name_zhinan.put(Values.SHIJIANGUANGCHANG,Integer.valueOf(R.array.shijianguangchangzhi));
    name_tupian.put(Values.SHIJIANGUANGCHANG,Integer.valueOf(R.array.shijianguangchangtu));
    name_tips.put(Values.SHIJIANGUANGCHANG,Integer.valueOf(R.array.shijianguangchangt));
    name_jianjie.put(Values.SHIJIANGUANGCHANG,R.string.shijianguangchang);
    name_zhinan.put(Values.SHIWAIYUNDONGCHANG,Integer.valueOf(R.array.shiwaiyundongchangzhi));
    name_tupian.put(Values.SHIWAIYUNDONGCHANG,Integer.valueOf(R.array.shiwaiyundongchangtu));
    name_tips.put(Values.SHIWAIYUNDONGCHANG,Integer.valueOf(R.array.shiwaiyundongchangt));
    name_jianjie.put(Values.SHIWAIYUNDONGCHANG,R.string.shiwaiyundongchang);

  }
}
