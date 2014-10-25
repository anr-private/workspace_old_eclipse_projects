package com.maranr.anrlogd;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class MainActivity extends Activity {
	
	String tag = "Events";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Log.d(tag, "+++ in onCreated()");
        super.onCreate(savedInstanceState);
        
        // hide title bar
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.main);
    }
    public void onStart() {
    	Log.d(tag, "in onStart()");
    	super.onStart();
    }
    public void onRestart() {
    	Log.d(tag, "in onRestart()");
    	super.onRestart();
    }
    public void onResume() {
    	Log.d(tag, "in onResume()");
    	super.onResume();
    }
    public void onPause() {
    	Log.d(tag, "in onPause()");
    	super.onPause();
    }
    public void onStop() {
    	Log.d(tag, "in onStop()");
    	super.onStop();
    }
    public void onDestroy() {
    	Log.d(tag, "in onDestroy()  ");
    	super.onDestroy();
    }

}