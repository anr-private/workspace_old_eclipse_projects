package com.maranr.anr_ui_activity22;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Demo 'activity'-level events:
 *   onKeyDown
 *   onKeyUp
 *   
 * Demo 'view'-level events on views like a Button or EditText:
 *   OnClickListener
 *   OnFocusChangeListener
 *   
 * @author tdir
 *
 */

public class MainActivity extends Activity {
	
	// single instance of click listener - shared by both buttons
	private OnClickListener btnListener = new OnClickListener() {
		
		public void onClick(View v) {
			Button b = (Button) v;
			String btnStg = "BTN CLICKED: " + b.getText();  
			Toast toast = Toast.makeText(getBaseContext(), btnStg, Toast.LENGTH_SHORT);
			toast.show();
		}
	};
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
	    // Both buttons share a single event handler
	    Button b1 = (Button)findViewById(R.id.button1);
	    Button b2 = (Button)findViewById(R.id.button2);
	    b1.setOnClickListener(this.btnListener);
	    b2.setOnClickListener(this.btnListener);
	    
	    EditText editText1 = (EditText) findViewById(R.id.editText1);
	    editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			public void onFocusChange(View v, boolean hasFocus) {
				EditText et = (EditText)v;
				String s = "EditText id=" + v.getId() +
						(hasFocus ? " has focus": " lost focus");
				Toast t = Toast.makeText(getBaseContext(), s,  Toast.LENGTH_SHORT);
				t.show();
			}
		});
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	Log.d("keydown", "KEY DOWN keycode=" + keyCode + " event=" + event);
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
    	
    	// This enables the 'back' button to return back to the desktop.
    	// Just returning 'false' does not - even though false means we did not consume
    	// the event(?!)
    	return super.onKeyDown(keyCode, event);
    }

    // The 2 buttons share the same event listener
}