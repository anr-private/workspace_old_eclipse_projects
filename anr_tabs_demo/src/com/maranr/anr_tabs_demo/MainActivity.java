package com.maranr.anr_tabs_demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TabHost tabs=(TabHost)findViewById(R.id.tabhost);
        
        tabs.setup();
        
        TabHost.TabSpec spec=tabs.newTabSpec("tag1");
        
        spec.setContent(R.id.tab1);
        spec.setIndicator("Clock");
        tabs.addTab(spec);
        
        spec=tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Button");
        tabs.addTab(spec);
    }
}