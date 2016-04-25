package com.example.x33_getsms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import com.example.x33_getsms.bean.Message;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Xml;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	List<Message> smsList;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        smsList = new ArrayList<Message>();
    }

    public void getSMS(View v){
    	//访问内容提供者获取短信
    	ContentResolver cr = getContentResolver();
    	//                         短信内容提供者的主机名
    	Cursor cursor = cr.query(Uri.parse("content://sms"), new String[]{"address","date","body","type"}, null, null, null, null);
    	
////    	***********************************************************
//    	//插入操作
//    	ContentValues values = new ContentValues();
//    	values.put("address", "15129280080");
//    	values.put("type", 1);
//    	values.put("body", "这里是短信内容~~~~~~~");
//    	values.put("date", System.currentTimeMillis());
//    	cr.insert(Uri.parse("content://sms"), values);
//    	
////    	***********************************************************
    	
    	while(cursor.moveToNext()){
    		String address = cursor.getString(0);
    		long date = cursor.getLong(1);
    		String body = cursor.getString(2);
    		int type = cursor.getInt(3);
    		
    		Message msg = new Message(address, body, date, type);
    		smsList.add(msg);
    		
    		Toast.makeText(this, "已获取系统短信内容，请备份", Toast.LENGTH_SHORT).show();
    	}
    }
    
    public void copySMS(View v){
    	XmlSerializer xs = Xml.newSerializer();
    	File file = new File("sdcard/sms.xml");
    	try {
			FileOutputStream fos = new FileOutputStream(file);
			xs.setOutput(fos, "utf-8");
			
			xs.startDocument("utf-8", true);
			
			xs.startTag(null, "message");
			
			for (Message msg : smsList) {
				xs.startTag(null, "sms");
				
				xs.startTag(null, "address");
				xs.text(msg.getAddress());
				xs.endTag(null, "address");
				
				
				xs.startTag(null, "body");
				xs.text(msg.getBody());
				xs.endTag(null, "body");
				
				
				xs.startTag(null, "date");
				xs.text(String.valueOf(msg.getDate()));
				xs.endTag(null, "date");
				
				
				xs.startTag(null, "type");
				xs.text(String.valueOf(msg.getType()));
				xs.endTag(null, "type");
				
				xs.endTag(null, "sms");
			}
			
			xs.endTag(null, "message");
			
			xs.endDocument();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
