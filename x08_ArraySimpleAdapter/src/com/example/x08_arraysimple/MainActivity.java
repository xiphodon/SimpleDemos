package com.example.x08_arraysimple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.x08_arrayadapter.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView lv = (ListView) findViewById(R.id.lv);

//        String[] str = new String[]{
//        		"小明",
//        		"小张",
//        		"小花"
//        };
//        
//          //只能处理一种类型数据
//        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.item_arrayadapter, R.id.tv, str));
//    
    
        
        //使用simpleAdapter   可以处理多种数据
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("photo", R.drawable.che1);
        map1.put("name", "小明");
        data.add(map1);
        
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("photo", R.drawable.che2);
        map2.put("name", "小花");
        data.add(map2);
        
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("photo", R.drawable.che3);
        map3.put("name", "小张");
        data.add(map3);
        
        lv.setAdapter(new SimpleAdapter(this, data, R.layout.item_arrayadapter,
        		new String[]{"photo","name"}, new int[]{R.id.iv,R.id.tv}));
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
