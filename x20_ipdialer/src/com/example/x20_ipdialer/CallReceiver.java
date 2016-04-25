package com.example.x20_ipdialer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class CallReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		//添加IP线路
		//截取拨号器发出的广播中拨出的号码（数据）
		String number = getResultData();
		
		if(number.startsWith("0")){
			//使用上下文参数
			SharedPreferences sp = context.getSharedPreferences("ip", context.MODE_PRIVATE);
			String ipNumber = sp.getString("ipNumber", "");
			
			number = ipNumber + number;
			//把新号码从新放入广播中
			setResultData(number);
		}
		
	}

}
