package com.exe.feife.wzkd2.wzkd.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.exe.feife.wzkd2.wzkd.R;

public class ZhinanActivity extends Activity
{
    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_zhinan);
    }

    public void tojieshao(View view) {
       finish();
    }

    /*
    * 查看公交表大图*/
    public void ShiKe(View v)
    {
        Toast.makeText(this,"点击查看时刻表",Toast.LENGTH_SHORT);
        //请在这里设置点击跳转的Intent，
                /*
                *
                Intent i=new Intent(this,ActivityBroswePic.class);
                i.putExtra("picture", R.mipmap.shikebiao);
                startActivity(i);
                */
    }
}