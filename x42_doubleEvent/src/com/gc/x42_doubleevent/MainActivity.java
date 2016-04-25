package com.gc.x42_doubleevent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * 模拟双击事件
 * @author guochang
 *
 */
public class MainActivity extends Activity {

    private long firstClickTime;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   public void onClick(View view){
	   
	   if(firstClickTime >0){//已经行过一次点击
		   if(System.currentTimeMillis() - firstClickTime < 500){//两次点击事件差不超过500毫秒
			   Toast.makeText(this, "双击", Toast.LENGTH_SHORT).show();
			   //双击事件完成后初始化firstClickTime
			   firstClickTime = 0;
			   return;
		   }
		   
	   }
	   
	   firstClickTime = System.currentTimeMillis();
   }
    
}
