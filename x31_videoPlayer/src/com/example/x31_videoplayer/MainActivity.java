package com.example.x31_videoplayer;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ºÏ≤‚ «∑Ò÷ß≥÷vitamio
        if(!LibsChecker.checkVitamioLibs(this)){return;}
        
        VideoView vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoPath("sdcard/test.rmvb");
        vv.start();
        vv.setMediaController(new MediaController(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
