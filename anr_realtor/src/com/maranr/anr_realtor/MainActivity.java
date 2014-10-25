package com.maranr.anr_realtor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	int theRequestCode = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // keep keyboard from popping up on some devices
       this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); 
        this.setContentView(R.layout.main);
        

    }
    
    public void selectClient(View v)
    {
    	Log.d("selectClient", "CALLED view="+v);
    	Object tag = v.getTag();
    	Log.d("selectClient", "view TAG=" + tag.getClass().getName() + " " + tag);
    	String tagStg = tag.toString();
    	
		Intent intent = new Intent("com.maranr.PROPERTY_PAGE");
		
		// Add info to the intent so Property Page can use it as input
		Bundle bundle = new Bundle();
		bundle.putString("Name", "(suggest you enter your name)");
		bundle.putString("propertyId", tagStg);
		intent.putExtras(bundle);

		startActivityForResult(intent, theRequestCode);
    }
    
    public void addNewClient(View v)
    {
    	Log.d("addNewClient", "CALLED");
    	String s = "(Not available yet)";
		Toast t = Toast.makeText(this, s, Toast.LENGTH_SHORT);
		t.show();
    }
    
    // When Property Page returns, it sends us a result.
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	
    	Log.d("MainACT", "onActivityResult CALLED");
    	String ss = "onActivityResult got req=" + Integer.toString(requestCode) + 
    			" result=" + Integer.toString(resultCode);
    	Log.d("MainACT", ss);

    	String s = "??";
    	if (resultCode == RESULT_CANCELED) {
    		ss = "ResultCode " + Integer.toString(resultCode) + " means 'CANCELLED'";
    		s = "CANCELLED";
    	} else if (resultCode == RESULT_OK) {
    		ss = "ResultCode " + Integer.toString(resultCode) + " means 'OK'";
    		s = "OK";
    	} else {
    		ss = "ResultCode " + Integer.toString(resultCode) + " is an UNKNOWN value";
    		s = "UNKNOWN=" + resultCode;
    	}    		
    	Log.d("Act1Event", ss);
    	
    	String uname = null;
    	Log.d("MainACT", "intent=" + intent);
    	if (intent != null) {
	    	Bundle bundle = intent.getExtras();
	    	Log.d("MainACT", "extras bundle=" + bundle);
	    	if (bundle != null) {
	   			uname = bundle.getString("uname");
	    	}
    	}
	   	s = s + " UNAME=" + uname;
    	Toast t = Toast.makeText(this, s, Toast.LENGTH_SHORT);
    	t.show();
 	
    	/* @@@@
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
    	*/
    }
    

}