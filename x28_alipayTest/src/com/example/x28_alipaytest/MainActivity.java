package com.example.x28_alipaytest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
//
//	
//	远程服务  aidl  使用方法
//	1.把远程服务的方法抽取成一个单独的接口xxx.java文件
//	2.把接口xxx.java文件的后缀改为xxx.aidl
//	3.在gen文件夹中自动生成的同名xxx.java文件中，有一个静态抽象类Stub，它已经继承了Binder类，
//	      并实现了xxx.java接口，这个类就是新的中间人
//	4.把aidl文件复制到调用者的项目中，注意：aidl文件的所在包名，必须要和被调用服务项目中aidl的包名一致
//	5.在调用者项目中，强转中间人对象时，直接使用Stub.asInterface(Service)方法
//	
//	
//	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
