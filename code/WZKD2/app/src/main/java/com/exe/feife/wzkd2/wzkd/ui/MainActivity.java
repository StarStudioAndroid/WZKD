package com.exe.feife.wzkd2.wzkd.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;

import com.exe.feife.wzkd2.wzkd.R;
import com.exe.feife.wzkd2.wzkd.data.Values;

public class MainActivity extends Activity {
    Spinner s;
    String[] positions={Values.CHENGDIANHUITANG,Values.HUODONGZHONGXIN,Values.KEYANLOU,
            Values.PINGXUELOU,Values.SHANGEYEJIE,Values.TIYUYUNDONGZHONGXIN,
            Values.XIAOYIYUAN,Values.TUSHUGUAN,Values.ZHULOU,
            Values.YINGXINGDADAO,Values.ZONGHELOU,Values.ZONGHEXUNLIANGUAN,Values.YISHITANG,
            Values.ERSHITANG,Values.SHIYANLOU,Values.SHIJIANGUANGCHANG,Values.SHIWAIYUNDONGCHANG};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s= (Spinner) findViewById(R.id.spinner);
        s.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, positions));
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position!=0)
                {
                    Intent i=new Intent(MainActivity.this,JieshaoActivity.class);
                    i.putExtra(Values.WEIZHINAME,positions[position]);
                    startActivity(i);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void jieshao(View v)
    {
        Intent intent=new Intent(this,JieshaoActivity.class);
        startActivity(intent);
    }

    public void xueba(View v)
    {
        Intent intent=new Intent(this,XuebaActivity.class);
        startActivity(intent);
    }

    public void zhinan(View v)
    {
        Intent intent=new Intent(this,ZhinanActivity.class);
        startActivity(intent);
    }

    public void shoucang(View v)
    {
        Intent intent=new Intent(this,CollectActivity.class);
        startActivity(intent);
    }
}
