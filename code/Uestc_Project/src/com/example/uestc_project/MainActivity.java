package com.example.uestc_project;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private ListView listView;
    private Button button_back;
    private List<HashMap<String,Object>>list = new ArrayList<HashMap<String,Object>>();
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        button_back = (Button)findViewById(R.id.button_back_main);
        button_back.setText("<返回");
        button_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "你点了返回", Toast.LENGTH_SHORT).show();
			}
		});
        listView = (ListView)findViewById(R.id.list_main_show);
        int []pics = {R.drawable.book,R.drawable.foot,R.drawable.fire};
        String []words = {"学霸生活","出行指南","关于软件"};
        String [] guides = {">",">",">"};
        for(int i =0;i<3;i++){
            HashMap<String,Object>data = new HashMap<String, Object>();
            data.put("pics",pics[i]);
            data.put("words",words[i]);
            data.put("guides",guides[i]);
            list.add(data);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.item,new String[]{"pics","words","guides"},new int[]{R.id.image_item_show,R.id.text_item_word,R.id.text_item_guide} );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	
                String words = (String)list.get(position).get("words");
                if (words == "学霸生活"){
                    Toast.makeText(MainActivity.this, "你点了学霸生活",Toast.LENGTH_SHORT).show();
                }
                
                if (words == "出行指南"){
                   Toast.makeText(MainActivity.this, "你点了出行指南", Toast.LENGTH_SHORT).show();
                }
                
                if (words == "关于软件"){
                	Toast.makeText(MainActivity.this, "你点了关于软件", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
