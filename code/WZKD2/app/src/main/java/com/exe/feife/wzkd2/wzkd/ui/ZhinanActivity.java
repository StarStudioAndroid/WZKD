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
        Intent intent=new Intent(ZhinanActivity.this,JieshaoActivity.class);
        startActivity(intent);
    }
}