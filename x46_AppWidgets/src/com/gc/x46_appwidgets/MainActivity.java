package com.gc.x46_appwidgets;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * 桌面小部件：
 * 1,清单文件配置创建元数据，广播接收者
 * 2，新建广播接收者，
 * 3，新建xml文件，res/xml/目录下
 * 4，实现xml内部内容
 * 
 * @author guochang
 *
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   
    
}
