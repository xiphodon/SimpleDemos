package com.example.x20_ipdialer;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View v){
    	EditText et = (EditText) findViewById(R.id.et);
    	//零散数据，使用 SharedPreferences 存储
    	SharedPreferences sp = getSharedPreferences("ip", MODE_PRIVATE);
    	sp.edit().putString("ipNumber", et.getText().toString()).commit();
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
