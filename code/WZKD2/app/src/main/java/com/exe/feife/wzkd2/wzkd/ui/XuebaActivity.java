package com.exe.feife.wzkd2.wzkd.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.exe.feife.wzkd2.wzkd.R;

public class XuebaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xueba);
    }
    public void finish(View v)
    {
        finish();
    }

}
