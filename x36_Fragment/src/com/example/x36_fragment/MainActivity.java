package com.example.x36_fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//使用import android.support.v4.app.FragmentActivity包
public class MainActivity extends FragmentActivity {

    private Fragment03 fg3;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
    	//创建Fragment01对象
    	Fragment01 fg1 = new Fragment01();
    	//获取fragment管理器
    	FragmentManager fm = getSupportFragmentManager();
    	//开启事务
    	FragmentTransaction ft = fm.beginTransaction();
    	//把内容显示至帧布局
    	ft.replace(R.id.fl, fg1);
    	//提交
    	ft.commit();
    }
    
    public void click1(View v){
    	//创建Fragment01对象
    	Fragment01 fg1 = new Fragment01();
    	//获取fragment管理器
    	FragmentManager fm = getSupportFragmentManager();
    	//开启事务
    	FragmentTransaction ft = fm.beginTransaction();
    	//把内容显示至帧布局
    	ft.replace(R.id.fl, fg1);
    	//提交
    	ft.commit();
    }

    
    public void click2(View v){
    	//创建Fragment02对象
    	Fragment02 fg2 = new Fragment02();
    	//获取fragment管理器
    	FragmentManager fm = getSupportFragmentManager();
    	//开启事务
    	FragmentTransaction ft = fm.beginTransaction();
    	//把内容显示至帧布局
    	ft.replace(R.id.fl, fg2);
    	//提交
    	ft.commit();
    }
    
    
    public void click3(View v){
    	fg3 = new Fragment03();
    	//获取fragment管理器
    	FragmentManager fm = getSupportFragmentManager();
    	//开启事务
    	FragmentTransaction ft = fm.beginTransaction();
    	//把内容显示至帧布局
    	ft.replace(R.id.fl, fg3);
    	//提交
    	ft.commit();
    }
    
    public void click4(View v){
    	
    	EditText et_main = (EditText) findViewById(R.id.et_main);
    	String text = et_main.getText().toString();
    	//传递数据
    	fg3.setText(text);
    }
    
    public void setText(String text){
    	TextView tv_main = (TextView) findViewById(R.id.tv_main);
    	tv_main.setText(text);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
