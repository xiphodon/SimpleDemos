package com.example.x27_registerbroadbyservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		if(Intent.ACTION_SCREEN_ON.equals(action)){
			
			System.out.println("ÆÁÄ»´ò¿ª");
			
		}else if(Intent.ACTION_SCREEN_OFF.equals(action)){
			
			System.out.println("ÆÁÄ»¹Ø±Õ");
		}
	}

}
