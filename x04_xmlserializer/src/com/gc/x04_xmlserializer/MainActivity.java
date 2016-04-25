package com.gc.x04_xmlserializer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import com.gc.x04_xmlserializer.message.Message;

import android.os.Bundle;
import android.app.Activity;
import android.util.Xml;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	List<Message> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<Message>();
        for(int i=0;i<10;i++){
        	Message mes = new Message("1513930000"+i, System.currentTimeMillis()+"", "接收", "短信内容"+i);
        	list.add(mes);
        }
    }
    
    
public void click(View v){
	//得到序列化器
	XmlSerializer xs = Xml.newSerializer();
	File file = new File("sdcard/sms.xml");
	try {
		FileOutputStream fos = new FileOutputStream(file);
		//指定用什么编码生成XML
		xs.setOutput(fos, "utf-8");
		//第二个参数表示xml文件是否为独立文件
		xs.startDocument("utf-8", true);
		
		xs.startTag(null, "message");
		for(Message ms:list){
			xs.startTag(null, "sms");
			
			xs.startTag(null, "address");
			xs.text(ms.getAddress());
			xs.endTag(null, "address");
			
			xs.startTag(null, "date");
			xs.text(ms.getDate());
			xs.endTag(null, "date");
			
			xs.startTag(null, "type");
			xs.text(ms.getType());
			xs.endTag(null, "type");
			
			xs.startTag(null, "body");
			xs.text(ms.getBody());
			xs.endTag(null, "body");
			
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
