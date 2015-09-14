package com.exe.feife.wzkd2.wzkd.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.exe.feife.wzkd2.wzkd.R;
import com.exe.feife.wzkd2.wzkd.ui.view.SlideListView2;

import java.util.ArrayList;

public class CollectActivity extends Activity implements AdapterView.OnItemClickListener {
    private SlideListView2 collectionList;
    private ArrayList<String> didian;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        mContext=this;
        collectionList= (SlideListView2) findViewById(R.id.lv_collect);
        collectionList.setAdapter(new MyAdapter(this));
        collectionList.initSlideMode(SlideListView2.MOD_RIGHT);
        collectionList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(mContext, JieshaoActivity.class);
        intent.putExtra("weizhiname", didian.get(position));
        startActivity(intent);
    }

    class MyAdapter extends BaseAdapter {

        private SharedPreferences sp;
        private Editor editor;
        private Activity mContext;
        public MyAdapter(Activity context)
        {
            mContext=context;
            didian=new ArrayList<String>();
            sp=mContext.getSharedPreferences("collect", MODE_PRIVATE);
            editor=sp.edit();
            for (String s:sp.getAll().keySet())
            {
                if (sp.getInt(s,0)==1)
                {
                    didian.add(s);
                }
            }
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
//                viewHolder.View=(Button)v.findViewById(R.id.rl_list_item_view);
                viewHolder.delete= (RelativeLayout) v.findViewById(R.id.rl_list_item_delete);
                v.setTag(viewHolder);
            }
            viewHolder=(ViewHolder) v.getTag();
            viewHolder.name.setText(didian.get(position));
//            viewHolder.View.setTag(didian.get(position));
            viewHolder.delete.setTag(didian.get(position));
            //查看的点击事件
            /*viewHolder.View.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, JieshaoActivity.class);
                    intent.putExtra("weizhiname", didian.get(position));
                    startActivity(intent);
                }
            });*/
            //删除的点击事件
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
 //       public Button View;
        public RelativeLayout delete;
    }
    //刷新界面
    public void refreshView()
    {
        collectionList.setAdapter(new MyAdapter(this));
    }

}
