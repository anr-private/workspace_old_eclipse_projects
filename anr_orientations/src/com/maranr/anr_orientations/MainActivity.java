package com.maranr.anr_orientations;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;


/** Demo events that are fired when orientation is changed (landscape/portrait)
 * Includes saving state using various events.
 * Also how to determine the current orientation using window manager.
 * 
 * You can force an orientation in the manifest file using this attrib
 * on the <activity>:   android:screenOrientation="landscape"  or "portrait"
 * NOTE in emulator window, use control-F11 to change orientation.
 * 
 * @author tdir
 */

public class MainActivity extends Activity {

	
	public boolean landscapeFlag = true;
	public int orientState = 0;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Log.d("stateInfo", "onCreate");
    	// retrieve the value saved in onRetainNonConfigurationInstance()
    	// it's null at initial startup
    	String s = (String) getLastNonConfigurationInstance();
    	Log.d("stateInfo", "onCreate got last NonConfig instance='" + s + "'");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // determine orientation using window manager
        WindowManager wm = getWindowManager();
        Display display = wm.getDefaultDisplay();
        if (display.getWidth() > display.getHeight()) {
        	Log.d("orient", "LANDSCAPE w=" + display.getWidth() +
					" h=" + display.getHeight());
        } else {
        	Log.d("orient", "PORTRAIT w=" + display.getWidth() +
					" h=" + display.getHeight());
        }
        
        if (false) {
        	// Force display to a specific orientation
        	if (landscapeFlag) {
        		Log.d("forceMode", "LANDSCAPE MODE forced!");
        		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        	} else {
        		Log.d("forceMode", "PORTRAIT MODE forced!");
        		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        	}
    		landscapeFlag = ! landscapeFlag;
        }
        
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if (orientState == 0) {
	        		Log.d("forceMode", "USER ORIENTATION MODE forced!");
	        		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
				} else if (orientState == 1) {
		       		Log.d("forceMode", "LANDSCAPE MODE forced!");
	        		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				} else if (orientState == 2) {
	        		Log.d("forceMode", "PORTRAIT MODE forced!");
	        		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				} else {
					Log.d("error!", "unknown orientState=" + orientState);
				}
				orientState += 1;
				if (orientState >= 3) {
					orientState = 0;
				}
			}
		});
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
    	Log.d("stateInfo", "onSaveInstanceState - 'save' values");
    	savedInstanceState.putString("s", "MY STRING");
    	savedInstanceState.putInt("i", 123);
    	savedInstanceState.putDouble("d", 123.456);
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
    	String s = savedInstanceState.getString("s");
    	Integer i = savedInstanceState.getInt("i");
    	Double d = savedInstanceState.getDouble("d");
    	Log.d("stateInfo", "onRestoreInstanceState s='" + s + "'  i=" + i + "  d=" + d);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public Object onRetainNonConfigurationInstance() {
    	Log.d("stateInfo", "onSaveInstanceState - 'save' values");
    	return "THIS IS SAVE IN onRetainNonConfigurationInstance";
    }
    	
    	
    	@Override
    public void onStart() {
    	Log.d("stateInfo", "onStart");
    	super.onStart();
    }
    @Override
    public void onResume() {
    	Log.d("stateInfo", "onResume");
    	super.onResume();
    }
    @Override
    public void onPause() {
    	Log.d("stateInfo", "onPause");
    	super.onPause();
    }
    @Override
    public void onStop() {
    	Log.d("stateInfo", "onStop");
    	super.onStop();
    }
    @Override
    public void onDestroy() {
    	Log.d("stateInfo", "onDestroy");
    	super.onDestroy();
    }
    @Override
    public void onRestart() {
    	Log.d("stateInfo", "onRestart");
    	super.onRestart();
    }
}
