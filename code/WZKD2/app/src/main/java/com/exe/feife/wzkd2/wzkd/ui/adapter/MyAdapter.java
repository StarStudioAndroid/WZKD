package com.exe.feife.wzkd2.wzkd.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.exe.feife.wzkd2.wzkd.R;

import java.util.ArrayList;

/**
 * Created by feifei on 15-8-31.
 */
public class MyAdapter extends BaseAdapter {
    //
    private ArrayList<String> didian;
    private Activity mContext;


    @Override
    public int getCount() {
        return 0;
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

            }
        });
        return v;
    }

    static class ViewHolder
    {
        public TextView name;
        public Button View;
        public Button delete;
    }
}
