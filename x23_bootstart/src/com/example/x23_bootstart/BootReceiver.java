package com.example.x23_bootstart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		//实现开机启动
		Intent it = new Intent(context, MainActivity.class);
		it.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(it);
	}

}
