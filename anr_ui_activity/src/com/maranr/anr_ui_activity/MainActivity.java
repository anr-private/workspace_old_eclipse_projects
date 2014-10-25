package com.maranr.anr_ui_activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * Demo GUI activity events including 
 *  onKeyDown
 *  onKeyUp
 *
 * @author tdir
 *
 */
public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	switch (keyCode) {
    	case KeyEvent.KEYCODE_DPAD_CENTER:
    		Toast.makeText(getBaseContext(), "CENTER btn was clicked", Toast.LENGTH_SHORT).show();
    		Log.d("keydown", "CENTER btn clicked");
    		break;
    	case KeyEvent.KEYCODE_DPAD_LEFT:
    		Toast.makeText(getBaseContext(), "LEFT btn was clicked", Toast.LENGTH_SHORT).show();
    		Log.d("keydown", "LEFT btn clicked");
    		break;
    	case KeyEvent.KEYCODE_DPAD_RIGHT:
    		Toast.makeText(getBaseContext(), "RIGHT btn was clicked", Toast.LENGTH_SHORT).show();
    		Log.d("keydown", "RIGHT btn clicked");
   		break;
    	case KeyEvent.KEYCODE_DPAD_UP:
    		Toast.makeText(getBaseContext(), "UP btn was clicked", Toast.LENGTH_SHORT).show();
    		Log.d("keydown", "UP btn clicked");
    		break;
    	case KeyEvent.KEYCODE_DPAD_DOWN:
    		Toast.makeText(getBaseContext(), "DOWN btn was clicked", Toast.LENGTH_SHORT).show();
    		Log.d("keydown", "DOWN btn clicked");
    		break;
    	}//switch
    	
    	return false; // pass event on to next listener
    }
}