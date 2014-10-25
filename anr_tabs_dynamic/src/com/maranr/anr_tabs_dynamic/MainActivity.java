package com.maranr.anr_tabs_dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TabHost;

public class MainActivity extends Activity {
	
	  private TabHost tabsHost=null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    
        this.tabsHost=(TabHost)findViewById(R.id.tabhost);
        this.tabsHost.setup();
        
        TabHost.TabSpec spec = this.tabsHost.newTabSpec("buttontab");
        spec.setContent(R.id.buttontab);
        spec.setIndicator("Button1");
        this.tabsHost.addTab(spec);
    
    }
    
    /**
     * This is invoked both by onCreate() and by the button;
     * the latter because main.xml specifies the callback
     * when button pressed:
     *         android:onClick="addTab"
     * (See main.xml)
     * 
     */
    public void addTab(View v) {
        TabHost.TabSpec spec = tabsHost.newTabSpec("tag1");
        
        TabHost.TabContentFactory factory = new TabHost.TabContentFactory() {
        	public View createTabContent(String tag) {
        		Context context = MainActivity.this;
        		View view = new AnalogClock(context);
        		return view;
        		//@@@WAS return(new AnalogClock(MainActivity.this));
            }
          };
        spec.setContent(factory);
        /*
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
              return(new AnalogClock(MainActivity.this));
            }
          });
        */
        spec.setIndicator("Clock");
        tabsHost.addTab(spec);
      }
    
}