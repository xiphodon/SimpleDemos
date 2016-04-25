package com.example.x28_alipaytest;

import com.example.x28_alipaytest.PayInterface.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

public class PayService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new PayBinder();
	}
	
	//中间人对象
	class PayBinder extends Stub{

		@Override
		public void pay() throws RemoteException {
			// TODO Auto-generated method stub
			//调用服务的 pay() 方法
			PayService.this.pay();
		}
		
	}
	
	public void pay(){
		System.out.println("检测运行环境...");
		System.out.println("加密用户名密码...");
		System.out.println("建立连接...");
		System.out.println("上传数据...");
		System.out.println("支付完成~");
	}

}
