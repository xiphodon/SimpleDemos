package com.example.x09_dialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    
    public void click1(View v){
    	//新建一个对话框的创建器
    	AlertDialog.Builder builder = new Builder(this);
    	
    	builder.setIcon(android.R.drawable.arrow_down_float);
    	builder.setTitle("删除数据");
    	builder.setMessage("是否确定清楚数据，该操作不可逆，可能会导致该应用读取数据发生异常");
    	//创建确定按钮
    	builder.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "删除数据成功", Toast.LENGTH_SHORT).show();
			}
		});
    	//创建取消按钮
    	builder.setNegativeButton("取消", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "取消删除数据", Toast.LENGTH_SHORT).show();
			}
		});
    	
    	//创建器生成对话框
    	AlertDialog ad = builder.create();
    	ad.show();
    	
    	
    }
    
    
    public void click2(View v){
    	AlertDialog.Builder builder = new Builder(this);
    	builder.setIcon(android.R.drawable.arrow_down_float);
    	builder.setTitle("选择性别：");
    	
    	final String[] items = new String[]{
    			"男",
    			"女"
    	};
    	
    	//设置单选选择项                                                     //选项      //默认选项      //选择后发生事件
    	builder.setSingleChoiceItems(items, -1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "您选择了：" + items[which], Toast.LENGTH_SHORT).show();
				//使对话框消失
				dialog.dismiss();
			}
		});
    	
    	builder.show();
    }
    
    
    public void click3(View v){
    	AlertDialog.Builder builder = new Builder(this);
    	builder.setIcon(android.R.drawable.arrow_down_float);
    	builder.setTitle("选择向往的城市：");
    	
    	final String[] items = new String[]{
    		"北京",
    		"上海",
    		"广州",
    		"郑州"
    	};
    	
    	final boolean[] checkedItems = new boolean[]{
    			true,
    			false,
    			true,
    			false
    	};
    	
    	builder.setMultiChoiceItems(items, checkedItems,new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// TODO Auto-generated method stub
				checkedItems[which] = isChecked;
			}
		});
    	
    	builder.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				String text = "";
				for(int i=0;i<items.length;i++){
					text += checkedItems[i] ? items[i] +"," : "" ;
				}
				if("".equals(text)){
					text = "您没有选择任何城市";
				}
				Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
			}
		});
    	
    	builder.show();
    }
    
    
    
    
    
    
    
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
