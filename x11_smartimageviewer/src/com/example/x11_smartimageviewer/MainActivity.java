package com.example.x11_smartimageviewer;

import com.loopj.android.image.SmartImageView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    
    public void click(View v){
    	//下载图片
    	//1.确定网址
    	String path = "http://192.168.1.105:8080/wolf.jpg";
    	//2.取得智能图片查看器对象
    	SmartImageView siv = (SmartImageView) findViewById(R.id.siv);
    	//3.下载并显示图片
    	siv.setImageUrl(path);
    	
    }
    
    
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
