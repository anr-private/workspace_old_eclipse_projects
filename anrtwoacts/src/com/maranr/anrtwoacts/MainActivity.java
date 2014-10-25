package com.maranr.anrtwoacts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	String tag = "Events";
	int theRequestCode = 1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(tag, "in onCreate()");
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
    
  	
    	Log.d(tag, "keycode=" + Integer.toString(keyCode));
    	//String s = "event=" + Integer.toString(event);
   
    	if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
    		Intent intent = new Intent("com.maranr.ACTIVITY2");
    		    		
    		// OLDER: does not allow for a return value ---  startActivity(intent);
    		// theRequestCode is a tag that allows us to identify which activity is returning
    		// a result when onActivityResult() is called.

    		// Add info to the intent so activity 2 can use it as input
    		Bundle bundle = new Bundle();
    		bundle.putString("Name", "(suggest you enter your name)");
    		intent.putExtras(bundle);

    		startActivityForResult(intent, theRequestCode);
      		
    		return true; // consume the keystroke
    		
    	} else {
    		// allows the 'back' button to work correctly
           	return super.onKeyDown(keyCode, event);
    	}
    	//return true;
    }
/*
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
    	if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
    		Intent intent = new Intent("com.maranr.ACTIVITY2");
    		startActivity(intent);
    	} else {
    		super.onKeyDown(keyCode, event);
    	}
    	return false;
    }
*/    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	String ss = "onActivityResult got req=" + Integer.toString(requestCode) + 
    			" result=" + Integer.toString(resultCode);
    	Log.d("ACT1Event", ss);
    	if (resultCode == RESULT_CANCELED) {
    		ss = "ResultCode " + Integer.toString(resultCode) + " means 'CANCELLED'";
    	} else if (resultCode == RESULT_OK) {
    		ss = "ResultCode " + Integer.toString(resultCode) + " means 'OK'";
    	} else {
    		ss = "ResultCode " + Integer.toString(resultCode) + " is an UNKNOWN value";
    	}    		
    	Log.d("Act1Event", ss);
    	
    	
    	
    	if (requestCode == theRequestCode) {
    		if (resultCode == RESULT_OK) {
    			String s = intent.getData().toString();

    			TextView txt_view = (TextView)findViewById(R.id.txt_view);
    			txt_view.setText("YrName: " + s);
    			txt_view.setTextColor(Color.rgb(0, 155, 170));
    			Log.d("Act2Event", "INTENT data is '" + s + "'");
    			Toast t = Toast.makeText(this, s, Toast.LENGTH_SHORT);
    			t.show();
    		}
    	}
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