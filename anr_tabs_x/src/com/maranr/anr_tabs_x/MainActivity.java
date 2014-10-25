package com.maranr.anr_tabs_x;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TabHost;

public class MainActivity extends Activity {

	private TabHost tabs = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        
        tabs = (TabHost)findViewById(R.id.tabhost);
        tabs.setup();

        
        // ADD THE TABS to the tab host 
        //
        // NOTE that the order they are added here determines the
        // order of the tabs on the display.
        // Order of children in the main.xml does not matter,
        // just so all children all under the FrameLayout.
        TabHost.TabSpec spec = null;
        
        spec = tabs.newTabSpec("btns_tab");
        spec.setContent(R.id.btns_tab);
        spec.setIndicator("Buttons");
        tabs.addTab(spec);

        // The key to adding the 2nd tab is that it specifies
        // a different content.
        // Each content must be a child of the FrameLayout
        // under the TabHost - else tab mechanism will not see
        // the content.
        spec = tabs.newTabSpec("buttontab");
        spec.setContent(R.id.buttontab2);
        spec.setIndicator("Button2");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("buttontab");
        spec.setContent(R.id.buttontab);
        spec.setIndicator("Button");
        tabs.addTab(spec);
    }
      
    public void addNewTab(View v) {
    	// This is the button callback, set in main.xml.
    	// When invoked, it creates a new tab.
    	// The tab content factory creates the content - but not until
    	// the user clicks on the tab -- lazy instantiation of
    	// the content.
    	
    	Log.d("MAIN", "addTab called");
    	  
        TabHost.TabSpec spec = tabs.newTabSpec("tag1");
        
        TabHost.TabContentFactory factory = 
            	new TabHost.TabContentFactory() {
            		public View createTabContent(String tag) {
            			Log.d("createTabContent", "CREATE TAB CONTENT");
            			return(new AnalogClock(MainActivity.this));
            		}
            	};
        spec.setContent(factory);
        spec.setIndicator("Clock");
        tabs.addTab(spec);
      }
}