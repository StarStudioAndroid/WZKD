package com.exe.feife.wzkd2.wzkd.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.exe.feife.wzkd2.wzkd.R;
import com.exe.feife.wzkd2.wzkd.ui.view.MyImageFlipper;

import java.util.ArrayList;

public class CollectActivity extends Activity {
    private ListView collectionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        collectionList= (ListView) findViewById(R.id.lv_collect);
        collectionList.setAdapter(new MyAdapter(this));
    }
    class MyAdapter extends BaseAdapter {
        //
        private ArrayList<String> didian;
        private Activity mContext;
        private SharedPreferences sp;
        private Editor editor;


        public MyAdapter(Activity context)
        {
            mContext=context;
            sp=mContext.getSharedPreferences("collect",MODE_PRIVATE);
            didian=new ArrayList<String>();
            for (String s:sp.getAll().keySet())
            {
                if (sp.getInt(s,0)==1)
                {
                    didian.add(s);
                }
            }
            editor=sp.edit();
        }

        @Override
        public int getCount() {
            return didian.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=convertView;
            ViewHolder viewHolder=new ViewHolder();
            if (v==null)
            {
                v=mContext.getLayoutInflater().inflate(R.layout.item_collect,null);
                viewHolder.name= (TextView) v.findViewById(R.id.tv_list_item_name);
                viewHolder.View=(Button)v.findViewById(R.id.bt_list_item_view);
                viewHolder.delete= (Button) v.findViewById(R.id.bt_list_item_delete);
                v.setTag(viewHolder);
            }
            viewHolder=(ViewHolder)v.getTag();
            viewHolder.name.setText(didian.get(position));
            viewHolder.View.setTag(didian.get(position));
            viewHolder.delete.setTag(didian.get(position));
            viewHolder.View.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext,JieshaoActivity.class);
                    intent.putExtra("weizhiname",(String)v.getTag());
                    startActivity(intent);
                }
            });
            viewHolder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editor.putInt((String) v.getTag(), 0);
                    editor.commit();
                    refreshView();
                }
            });
            return v;
        }
    }
    static class ViewHolder
    {
        public TextView name;
        public Button View;
        public Button delete;
    }
    //刷新界面
    public void refreshView()
    {
        collectionList.setAdapter(new MyAdapter(this));
    }
}