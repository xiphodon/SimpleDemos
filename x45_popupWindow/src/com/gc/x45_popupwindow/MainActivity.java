package com.gc.x45_popupwindow;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView textView;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void click(View view){
    	textView = new TextView(this);
    	textView.setText("嘿嘿~~");
    	textView.setBackgroundColor(Color.GRAY);
    	
    	//popup动画
    	/**
    	 * 参数（1，要显示的组件      2，组件宽       3，组件高）
    	 */
    	PopupWindow popupWindow = new PopupWindow(textView, 200, 200);
    	/**
    	 * 参数（1，父View   2，重心向哪看齐     3，距重心x轴偏移量      4，距y轴偏移量）
    	 */
    	popupWindow.showAtLocation(findViewById(R.id.rl_root), Gravity.LEFT + Gravity.TOP, 300, 300);
    }
}
