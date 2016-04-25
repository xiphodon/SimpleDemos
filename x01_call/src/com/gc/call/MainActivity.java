package com.gc.call;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //获得按钮对象
        Button bt_call = (Button)findViewById(R.id.bt_call);
        //设置按钮监听事件
        bt_call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				   //取得编辑框对象
				   EditText et_num = (EditText)findViewById(R.id.et_num);
				   //取得编辑框内容
				   String number = et_num.getText().toString();
				   
				   
				   
				   //新建意图对象
				   Intent intent = new Intent();
				   
				   //隐式跳转     不同应用间activity跳转
				   //把动作封装到意图对象中
				   intent.setAction(intent.ACTION_CALL);
				   //设置打电话数据（电话号码，打给谁）
				   intent.setData(Uri.parse("tel:" + number));
				   
				   
				   
//				   //显式跳转       同一应用不同activity之间跳转        ("包名"，"包名+类名")
//				   intent.setClassName(packageContext, className);
				   
				   
				   //把动作告诉系统
				   startActivity(intent);
				   
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
