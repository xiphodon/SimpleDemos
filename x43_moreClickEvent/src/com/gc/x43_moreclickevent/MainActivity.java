package com.gc.x43_moreclickevent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * 多击事件
 * @author guochang
 *
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //数组长度就是点击次数
   long[] mHits = new long[3];
   
   public void onClick(View view){
	   System.arraycopy(mHits, 1, mHits, 0, mHits.length-1);
	   //当前已开机时间
       mHits[mHits.length-1] = SystemClock.uptimeMillis();
       if (mHits[0] >= (SystemClock.uptimeMillis()-500)) {
    	   Toast.makeText(this, "多击事件", Toast.LENGTH_SHORT).show();
       }
       
   }
   
   
    
}
