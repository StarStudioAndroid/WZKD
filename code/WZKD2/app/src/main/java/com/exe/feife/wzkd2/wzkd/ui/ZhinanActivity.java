package com.exe.feife.wzkd2.wzkd.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
    public void view(View v)
    {
        //请在这里设置点击跳转的Intent，
                /*
                *
                Intent i=new Intent(context,ActivityBroswePic.class);
                i.putExtra("picture", R.mipmap.shikebiao);
                startActivity(i);
                */
    }
}