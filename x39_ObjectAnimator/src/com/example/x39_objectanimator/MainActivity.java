package com.example.x39_objectanimator;

import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView iv;
	private ObjectAnimator oa1;
	private ObjectAnimator oa2;
	private ObjectAnimator oa3;
	private ObjectAnimator oa4;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        iv = (ImageView) findViewById(R.id.iv);
    }

    
    //平移
    public void click1(View v){
    	//      作用组件                   改变什么属性                              移动标记
    	oa1 = ObjectAnimator.ofFloat(iv, "translationX", 10,70,20,90,50,100);
    	oa1.setDuration(3000);
    	oa1.setRepeatCount(1);
    	oa1.setRepeatMode(ValueAnimator.REVERSE);
    	oa1.start();
    }
    
    
    //缩放
    public void click2(View v){
    	oa2 = ObjectAnimator.ofFloat(iv, "scaleX", 1,0.5f,1.5f,2);
    	oa2.setDuration(3000);
    	oa2.start();
    }
    
    
    //透明
    public void click3(View v){
    	oa3 = ObjectAnimator.ofFloat(iv, "alpha", 0,0.8f,0.4f,1);
    	oa3.setDuration(3000);
    	oa3.start();
    }
    
    
    //旋转
    public void click4(View v){
    	//      顺时针旋转
    	oa4 = ObjectAnimator.ofFloat(iv, "rotation", 0,90,-90,360);
    	oa4.setDuration(3000);
    	oa4.start();
    }

    
    //四种一起作用
    public void click5(View v){
    	AnimatorSet as = new AnimatorSet();
//    	//设置挨个执行
//    	as.playSequentially(oa1,oa2,oa3,oa4);
    	//设置一起执行
    	as.playTogether(oa1,oa2,oa3,oa4);
    	as.start();
    }
    
    
    //xml平移
    public void click6(View v){
    	//填充xml
    	Animator at = AnimatorInflater.loadAnimator(this, R.animator.objectanimator);
    	//设置作用于哪个组件
    	at.setTarget(iv);
    	at.start();
    }
    
    
    
    
    
    
    
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
