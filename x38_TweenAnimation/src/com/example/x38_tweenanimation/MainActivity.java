package com.example.x38_tweenanimation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView iv;
	private TranslateAnimation ta;
	private ScaleAnimation sa;
	private AlphaAnimation aa;
	private RotateAnimation ra;




	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        iv = (ImageView) findViewById(R.id.iv);
    }

	//位移
    public void click1(View v){
    	
    	ta = new TranslateAnimation(0, 100, 0, 100);
    	//移动时间
    	ta.setDuration(2000);
    	//再移动次数                                 +1
    	ta.setRepeatCount(1);
    	//移动模式    倒放一遍
    	ta.setRepeatMode(Animation.REVERSE);
    	//开始移动
    	iv.startAnimation(ta);
    }
    
    
    
    //缩放
    public void click2(View v){
//    	//                                          缩放倍数                                                   缩放焦点
//     	ScaleAnimation sa = new ScaleAnimation(0.5f, 2, 1, 3, iv.getWidth() / 2, iv.getHeight() / 2);
//                                                                 缩放焦点：      相对自己宽*0.5，高*0.5     	
    	sa = new ScaleAnimation(0.5f, 2, 1, 3, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
     	sa.setDuration(2000);
    	sa.setRepeatCount(1);
    	sa.setRepeatMode(Animation.REVERSE);
    	//停止为最后状态    
    	sa.setFillAfter(true);
    	iv.startAnimation(sa);
    }
    
    
    
    //透明
    public void click3(View v){
    	//从  全透明  到  完全不透明
    	aa = new AlphaAnimation(0, 1);
    	aa.setDuration(2000);
    	iv.startAnimation(aa);
    }

    
    
    //旋转
    public void click4(View v){
//    	//                                 旋转角度从  20度   到    190度   顺时针旋转            旋转中心为图片右下角
//    	RotateAnimation ra = new RotateAnimation(20, 190, iv.getWidth(), iv.getHeight());
    	//                                    旋转角度从  20度   到    190度   顺时针旋转            旋转中心为图片中心
    	ra = new RotateAnimation(20, 190, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    	ra.setDuration(2000);
    	iv.startAnimation(ra);
    }
    
    
    
    
    //四种共同作用
    public void click5(View v){
    	AnimationSet as = new AnimationSet(false);
    	as.addAnimation(aa);
    	as.addAnimation(ra);
    	as.addAnimation(sa);
    	as.addAnimation(ta);
    	
    	iv.startAnimation(as);
    	
    }
    
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
